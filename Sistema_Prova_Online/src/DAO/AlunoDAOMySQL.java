package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.Aluno;
import Objetos.MySQL;

public class AlunoDAOMySQL implements AlunoDAO {
	private MySQL mysql;
	
	public AlunoDAOMySQL() {
		this.mysql = new MySQL();
	}
	
	@Override
	public boolean inserirAluno( Aluno aluno ) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "aluno(codigo, nome, sobrenome, idade, fk_disciplina, fk_turma)";
		sql += "VALUES(";
		sql += aluno.getCodigo() + ", '" + aluno.getNome() + "','";
		sql += aluno.getSobrenome() + "'," + aluno.getIdade() + ", ";
		sql += aluno.getDisciplina().getCodigo() + ", " + aluno.getTurma().getCodigo() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarAluno( Aluno aluno ) {
		String sql;
		sql  = "UPDATE aluno ";
		sql += "SET ";
		sql += "nome='" + aluno.getNome() + "', ";
		sql += "sobrenome='" + aluno.getSobrenome() + "', ";
		sql += "idade=" + aluno.getIdade() + ", ";
		sql += "fk_disciplina="+ aluno.getDisciplina().getCodigo() + ", ";
		sql += "fk_turma=" + aluno.getTurma().getCodigo() + " ";
		sql += "WHERE codigo=" + aluno.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirAluno( Aluno aluno ) {
		String sql;
        sql  = "DELETE FROM aluno ";
        sql += "WHERE codigo = " + aluno.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Aluno consultarAluno( int codigo ){
		Aluno aluno = new Aluno();
		try {
			String sql = "SELECT * FROM aluno WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				aluno.setCodigo( codigo );
				aluno.setNome( rs.getString("nome") );
				aluno.setSobrenome( rs.getString("sobrenome") );
				aluno.setIdade( rs.getInt("idade") );
				//aluno.setDisciplina(  );
				//aluno.setTurma(  );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Aluno: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return aluno;
	}

	@Override
	public ArrayList<Aluno> consultarAluno(String nome, String sobrenome) {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			String sql;
			sql  = "SELECT * FROM aluno WHERE ";
			sql += "nome LIKE " + nome + "% AND sobrenome LIKE %" + sobrenome + "%";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Aluno aluno = new Aluno();
					aluno.setCodigo( rs.getInt("codigo") );
					aluno.setNome( rs.getString("nome") );
					aluno.setSobrenome( rs.getString("sobrenome") );
					aluno.setIdade( rs.getInt("idade") );
					//aluno.setDisciplina(  );
					//aluno.setTurma(  );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Aluno: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return alunos;
	}

	@Override
	public ArrayList<Aluno> listarAlunos() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		try {
			String sql;
			sql  = "SELECT * FROM aluno";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Aluno aluno = new Aluno();
					aluno.setCodigo( rs.getInt("codigo") );
					aluno.setNome( rs.getString("nome") );
					aluno.setSobrenome( rs.getString("sobrenome") );
					aluno.setIdade( rs.getInt("idade") );
					//aluno.setDisciplina(  );
					//aluno.setTurma(  );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Aluno: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return alunos;
	}
	
	public void fechar() {
		this.mysql.close();
	}

}
