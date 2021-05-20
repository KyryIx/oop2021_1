package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.Curso;
import Objetos.MySQL;

public class CursoDAOMySQL implements CursoDAO {
	private MySQL mysql;
	
	public CursoDAOMySQL() {
		this.mysql = new MySQL();
	}

	@Override
	public boolean inserirCurso(Curso curso) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "curso(codigo, nome, fk_grade)";
		sql += "VALUES(";
		sql += curso.getCodigo() + ", '" + curso.getNome() + "', ";
		sql += curso.getGrade().getCodigo() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarCurso(Curso curso) {
		String sql;
		sql  = "UPDATE curso ";
		sql += "SET ";
		sql += "nome='" + curso.getNome() + "', ";
		sql += "fk_grade='" + curso.getGrade().getCodigo() + " ";
		sql += "WHERE codigo=" + curso.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirCurso(Curso curso) {
		String sql;
        sql  = "DELETE FROM curso ";
        sql += "WHERE codigo = " + curso.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Curso consultarCurso(int codigo) {
		Curso curso = new Curso();
		try {
			String sql = "SELECT * FROM curso WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				curso.setCodigo( codigo );
				curso.setNome( rs.getString("nome") );
				
				GradeDAOMySQL gradeDAOMySQL = new GradeDAOMySQL();
				
				curso.setGrade( gradeDAOMySQL.consultarGrade( rs.getInt("fk_grade") ) );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Aluno: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return curso;
	}

	@Override
	public ArrayList<Curso> consultarCurso(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Curso> listarCursos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fechar() {
		this.mysql.close();
	}

}
