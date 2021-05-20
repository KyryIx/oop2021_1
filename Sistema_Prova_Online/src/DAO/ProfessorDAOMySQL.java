package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.MySQL;
import Objetos.Professor;

public class ProfessorDAOMySQL implements ProfessorDAO {
	private MySQL mysql;
	
	public ProfessorDAOMySQL() {
		this.mysql = new MySQL();
	}
	
	@Override
	public boolean inserirProfessor( Professor professor ) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "professor(codigo, nome, sobrenome, idade, fk_disciplina, fk_turma)";
		sql += "VALUES(";
		sql += professor.getCodigo() + ", '" + professor.getNome() + "','";
		sql += professor.getSobrenome() + "'," + professor.getIdade() + ", ";
		sql += professor.getDisciplina().getCodigo() + ", " + professor.getTurma().getCodigo() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarProfessor( Professor professor ) {
		String sql;
		sql  = "UPDATE professor ";
		sql += "SET ";
		sql += "nome='" + professor.getNome() + "', ";
		sql += "sobrenome='" + professor.getSobrenome() + "', ";
		sql += "idade=" + professor.getIdade() + ", ";
		sql += "fk_disciplina="+ professor.getDisciplina().getCodigo() + ", ";
		sql += "fk_turma=" + professor.getTurma().getCodigo() + " ";
		sql += "WHERE codigo=" + professor.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirProfessor( Professor professor ) {
		String sql;
        sql  = "DELETE FROM professor ";
        sql += "WHERE codigo = " + professor.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Professor consultarProfessor( int codigo ){
		Professor professor = new Professor();
		try {
			String sql = "SELECT * FROM professor WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				professor.setCodigo( codigo );
				professor.setNome( rs.getString("nome") );
				professor.setSobrenome( rs.getString("sobrenome") );
				professor.setIdade( rs.getInt("idade") );
				//professor.setDisciplina(  );
				//professor.setTurma(  );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Professor: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return professor;
	}

	@Override
	public ArrayList<Professor> consultarProfessor(String nome, String sobrenome) {
		ArrayList<Professor> professores = new ArrayList<Professor>();
		
		try {
			String sql;
			sql  = "SELECT * FROM professor WHERE ";
			sql += "nome LIKE " + nome + "% AND sobrenome LIKE %" + sobrenome + "%";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Professor professor = new Professor();
					professor.setCodigo( rs.getInt("codigo") );
					professor.setNome( rs.getString("nome") );
					professor.setSobrenome( rs.getString("sobrenome") );
					professor.setIdade( rs.getInt("idade") );
					//professor.setDisciplina(  );
					//professor.setTurma(  );
					professores.add( professor );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Professor: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return professores;
	}

	@Override
	public ArrayList<Professor> listarProfessores() {
		ArrayList<Professor> professores = new ArrayList<Professor>();
		
		try {
			String sql;
			sql  = "SELECT * FROM professor";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Professor professor = new Professor();
					professor.setCodigo( rs.getInt("codigo") );
					professor.setNome( rs.getString("nome") );
					professor.setSobrenome( rs.getString("sobrenome") );
					professor.setIdade( rs.getInt("idade") );
					//professor.setDisciplina(  );
					//professor.setTurma(  );
					professores.add( professor );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Professor: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return professores;
	}
	
	public void fechar() {
		this.mysql.close();
	}

}