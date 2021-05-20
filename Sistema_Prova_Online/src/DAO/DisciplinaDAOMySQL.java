package DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.Disciplina;
import Objetos.MySQL;

public class DisciplinaDAOMySQL implements DisciplinaDAO {
	private MySQL mysql;
	
	public DisciplinaDAOMySQL() {
		this.mysql = new MySQL();
	}
	
	@Override
	public boolean inserirDisciplina( Disciplina disciplina ) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "disciplina(codigo, nome, ementa) ";
		sql += "VALUES(";
		sql += disciplina.getCodigo() + ", '" + disciplina.getNome() + "','";
		sql += disciplina.getEmenta() + "')";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarDisciplina( Disciplina disciplina ) {
		String sql;
		sql  = "UPDATE disciplina ";
		sql += "SET ";
		sql += "codigo='" + disciplina.getCodigo() + "', ";
		sql += "nome='" + disciplina.getNome() + "', ";
		sql += "ementa='" + disciplina.getEmenta() + " ";
		sql += "WHERE codigo=" + disciplina.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirDisciplina( Disciplina disciplina ) {
		String sql;
        sql  = "DELETE FROM disciplina ";
        sql += "WHERE codigo = " + disciplina.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Disciplina consultarDisciplina( int codigo ){
		Disciplina disciplina = new Disciplina();
		try {
			String sql = "SELECT * FROM disciplina WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				disciplina.setCodigo( codigo );
				disciplina.setNome( rs.getString("nome") );
				disciplina.setEmenta( rs.getString("ementa") );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Disciplina: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return disciplina;
	}

	@Override
	public ArrayList<Disciplina> consultarDisciplina( String nome ) {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		try {
			String sql;
			sql  = "SELECT * FROM disciplina WHERE ";
			sql += "nome LIKE %" + nome + "%";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Disciplina disciplina = new Disciplina();
					disciplina.setCodigo( rs.getInt("codigo") );
					disciplina.setNome( rs.getString("nome") );
					disciplina.setEmenta( rs.getString("ementa") );

				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Disciplina: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return disciplinas;
	}

	@Override
	public ArrayList<Disciplina> listarDisciplinas() {
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		try {
			String sql;
			sql  = "SELECT * FROM disciplina";
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				
				do {
					Disciplina disciplina = new Disciplina();
					disciplina.setCodigo( rs.getInt("codigo") );
					disciplina.setNome( rs.getString("nome") );
					disciplina.setEmenta( rs.getString("ementa") );
				}while( rs.next() );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Disciplina: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return disciplinas;
	}
	
	public void fechar() {
		this.mysql.close();
	}
}