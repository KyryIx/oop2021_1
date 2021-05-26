package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.Curso;
import Objetos.MySQL;
import Objetos.Turma;

public class TurmaDAOMySQL implements TurmaDAO {
	private MySQL mysql;
	
	public TurmaDAOMySQL() {
		this.mysql = new MySQL();
	}
	
	@Override
	public boolean inserirTurma( Turma turma ) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "turma(codigo, fk_curso)";
		sql += "VALUES(";
		sql += turma.getCodigo() + ", " + turma.getCurso().getCodigo() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarTurma( Turma turma ) {
		String sql;
		sql  = "UPDATE turma ";
		sql += "SET ";
		sql += "nome=" + turma.getCodigo() + "', ";
		sql += "fk_curso='" + turma.getCurso().getCodigo() + ", ";
		sql += "WHERE codigo=" + turma.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirTurma( Turma turma ) {
		String sql;
        sql  = "DELETE FROM turma ";
        sql += "WHERE codigo = " + turma.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Turma consultarTurma( int codigo ){
		Turma turma = new Turma();
		try {
			String sql = "SELECT * FROM turma WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				turma.setCodigo( codigo );
				
				CursoDAOMySQL cursoDAOMySQL = new CursoDAOMySQL();
				turma.setCurso( cursoDAOMySQL.consultarCurso( rs.getInt("fk_curso") ) );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Turma: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return turma;
	}

	@Override
	public ArrayList<Turma> consultarTurma( Curso curso ) {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		try {
			String sql;
			sql  = "SELECT * FROM turma WHERE ";
			sql += "fk_curso=" + curso.getCodigo();
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Turma turma = new Turma();
					turma.setCodigo( rs.getInt("codigo") );
					CursoDAOMySQL cursoDAOMySQL = new CursoDAOMySQL();
					turma.setCurso( cursoDAOMySQL.consultarCurso( rs.getInt("fk_curso") ) );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Turma: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return turmas;
	}

	@Override
	public ArrayList<Turma> listarTurmas() {
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		try {
			String sql;
			sql  = "SELECT * FROM turma";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Turma turma = new Turma();
					turma.setCodigo( rs.getInt("codigo") );
					CursoDAOMySQL cursoDAOMySQL = new CursoDAOMySQL();
					turma.setCurso( cursoDAOMySQL.consultarCurso( rs.getInt("fk_curso") ) );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Turma: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return turmas;
	}
	
	public void fechar() {
		this.mysql.close();
	}
}
