package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.json.JSONArray;

import Objetos.Aluno;
import Objetos.Avaliacao;
import Objetos.Curso;
import Objetos.Disciplina;
import Objetos.MySQL;
import Objetos.Professor;
import Objetos.Questao;
import Objetos.Turma;

public class AvaliacaoDAOMySQL implements AvaliacaoDAO {
	private MySQL mysql;
	
	public AvaliacaoDAOMySQL() {
		this.mysql = new MySQL();
	}

	@Override
	public boolean inserirAvaliacao(Avaliacao avaliacao) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "avaliacao(codigo,fk_aluno,fk_turma,fk_disciplina,fk_professor,";
		sql += "fk_curso,dataAvaliacao,fk_questoes,respostas,fk_nota)";
		sql += "VALUES(";
		sql += avaliacao.getCodigo() + ",";
		sql += avaliacao.getAluno().getCodigo() + ",";
		sql += avaliacao.getTurma().getCodigo() + ",";
		sql += avaliacao.getDisciplina().getCodigo() + ",";
		sql += avaliacao.getProfessor().getCodigo() + ",";
		sql += avaliacao.getCurso().getCodigo() + ",";
		
		Calendar c = avaliacao.getDataAvaliacao();
		sql += "'" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "',";
		
		// https://github.com/stleary/JSON-java
		JSONArray json = new JSONArray();
		for( int i=0; i<avaliacao.getQuestoes().size(); i++ ) {
			json.put( avaliacao.getQuestoes().get(i).getCodigo() );
		}
		sql += "'" + json.toString() + "',";
		
		json = new JSONArray( avaliacao.getRespostas() );
		sql += "'" + json.toString()  + "',";
		
		sql += avaliacao.getNota().getCodigo() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarAvaliacao(Avaliacao avaliacao) {
		String sql;
		sql  = "UPDATE avaliacao ";
		sql += "SET ";
		sql += "fk_aluno=" + avaliacao.getAluno().getCodigo() + ", ";
		sql += "fk_turma=" + avaliacao.getTurma().getCodigo() + ", ";
		sql += "fk_disciplina=" + avaliacao.getDisciplina().getCodigo() + ", ";
		sql += "fk_professor=" + avaliacao.getProfessor().getCodigo() + ", ";
		sql += "fk_curso=" + avaliacao.getCurso().getCodigo() + ", ";
		
		Calendar c = avaliacao.getDataAvaliacao();
		sql += "dataAvaliacao='" + c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "', ";
		
		JSONArray json = new JSONArray();
		for( int i=0; i<avaliacao.getQuestoes().size(); i++ ) {
			json.put( avaliacao.getQuestoes().get(i).getCodigo() );
		}
		sql += "fk_questoes='" + json.toString() + "',";
		
		json = new JSONArray( avaliacao.getRespostas() );
		sql += "respostas='" + json.toString()  + "', ";
		
		sql += "fk_nota=" + avaliacao.getAluno().getCodigo() + " ";
		sql += "WHERE codigo=" + avaliacao.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirAvaliacao(Avaliacao avaliacao) {
		String sql;
        sql  = "DELETE FROM turma ";
        sql += "WHERE codigo = " + avaliacao.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Avaliacao consultarAvaliacao(int codigo) {
		Avaliacao avaliacao = new Avaliacao();
		try {
			String sql = "SELECT * FROM avaliacao WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				avaliacao.setCodigo( codigo );
				
				AlunoDAOMySQL alunoDAOMySQL = new AlunoDAOMySQL();
				avaliacao.setAluno( alunoDAOMySQL.consultarAluno( rs.getInt("fk_aluno") ) );
				alunoDAOMySQL.fechar();
				
				TurmaDAOMySQL turmaDAOMySQL = new TurmaDAOMySQL();
				avaliacao.setTurma( turmaDAOMySQL.consultarTurma( rs.getInt("fk_turma") ) );
				turmaDAOMySQL.fechar();
				
				DisciplinaDAOMySQL disciplinaDAOMySQL = new DisciplinaDAOMySQL();
				avaliacao.setDisciplina( disciplinaDAOMySQL.consultarDisciplina( rs.getInt("fk_disciplina") ) );
				disciplinaDAOMySQL.fechar();
				
				ProfessorDAOMySQL professorDAOMySQL = new ProfessorDAOMySQL();
				avaliacao.setProfessor( professorDAOMySQL.consultarProfessor( rs.getInt("fk_professor") ) );
				professorDAOMySQL.fechar();
				
				CursoDAOMySQL cursoDAOMySQL = new CursoDAOMySQL();
				avaliacao.setCurso( cursoDAOMySQL.consultarCurso( rs.getInt("fk_curso") ) );
				cursoDAOMySQL.fechar();
				
				String date = rs.getString("dataAvaliacao");
				SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd", Locale.getDefault() );
				try {
					Calendar calendar = Calendar.getInstance();
				    calendar.setTime( sdf.parse(date) );
				    avaliacao.setDataAvaliacao( calendar );
				} catch (ParseException e) {
					System.out.println( "Erro ao converter data em AvaliacaoDAO: " + e.toString() );
					//e.printStackTrace();
				}
				
				ArrayList<Questao> questoes = new ArrayList<Questao>();
				JSONArray json = new JSONArray( rs.getString("fk_questoes") );
				QuestaoDAOMySQL questaoDAOMySQL = new QuestaoDAOMySQL();
				for( int i=0; i<json.length(); i++ ) {
					Questao questao = questaoDAOMySQL.consultarQuestao( json.getInt(i) );
					questoes.add( questao );
				}
				questaoDAOMySQL.fechar();
				avaliacao.setQuestoes( questoes );
				
				json = new JSONArray( rs.getString("respostas") );
				int[] respostas = new int[ json.length() ];
				for( int i=0; i<json.length(); i++ ) {
					respostas[i] = json.getInt(i);
				}
				avaliacao.setRespostas( respostas );
				
				NotaDAOMySQL notaDAOMySQL = new NotaDAOMySQL();
				avaliacao.setNota( notaDAOMySQL.consultarNota( rs.getInt("fk_nota") ) );
				notaDAOMySQL.fechar();
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Avaliacao: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return avaliacao;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Aluno aluno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Disciplina disciplina) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> consultarAvaliacao(Calendar dataAvaliacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Avaliacao> listarAvaliacoes() {
		// TODO Auto-generated method stub
		return null;
	}

	public void fechar() {
		this.mysql.close();
	}
}
