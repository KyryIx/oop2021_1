package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objetos.MySQL;
import Objetos.Nota;

public class NotaDAOMySQL implements NotaDAO {
	private MySQL mysql;
	
	public NotaDAOMySQL() {
		this.mysql = new MySQL();
	}

	@Override
	public boolean inserirNota(Nota nota) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "nota(codigo, valor, peso)";
		sql += "VALUES(";
		sql += nota.getCodigo() + ", " + nota.getValor() + ", ";
		sql += nota.getPeso() + ")";
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarNota(Nota nota) {
		String sql;
		sql  = "UPDATE nota ";
		sql += "SET ";
		sql += "valor='" + nota.getValor() + "', ";
		sql += "peso=" + nota.getPeso() + " ";
		sql += "WHERE codigo=" + nota.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirNota(Nota nota) {
		String sql;
        sql  = "DELETE FROM nota ";
        sql += "WHERE codigo = " + nota.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Nota consultarNota(int codigo) {
		Nota nota = new Nota();
		try {
			String sql = "SELECT * FROM nota WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				nota.setCodigo( codigo );
				nota.setValor( rs.getFloat("valor") );
				nota.setPeso( rs.getFloat("peso") );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Nota: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return nota;
	}

	@Override
	public ArrayList<Nota> consultarNota(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Nota> listarNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void fechar() {
		this.mysql.close();
	}
}
