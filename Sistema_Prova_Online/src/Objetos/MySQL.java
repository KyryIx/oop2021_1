package Objetos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// procedimento obtido em:
// https://dev.mysql.com/doc/connector-j/5.1/en/connect
// or-j-usagenotes-connect-drivermanager.html

public class MySQL {
	private String host = "localhost";
	private String database = "test"; // schema = database
	private String user = "root";
	private String password = "root";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;
	
	public MySQL() {
		String strConn = "jdbc:mysql://" 
				+ this.host + "/"
				+ this.database + "?"
				+ "user=" + this.user
				+ "&password=" + this.password;
		
		try {
			this.conn = DriverManager.getConnection(strConn);
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public String getHost() {
		return this.host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Statement getStmt() {
		return stmt;
	}
	
	public void clearStmt() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {}
			stmt = null;
		}
	}
	
	public ResultSet getRs() {
		return rs;
	}
	
	public void clearRs() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {}

			rs = null;
		}
	}
	
	public int atualizar(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate( sql );
			return stmt.getUpdateCount();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return 0;
	}
	
	public boolean consultar(String sql){
		try {
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery( sql );
			if( rs.next() ) {
				return true;
			}
		}
		catch (SQLException ex) {
			System.out.println("SQLException Consultar: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return false;
	}
	
	public void close() {
		this.clearStmt();
		this.clearRs();
		try {
			this.conn.close();
		}
		catch (SQLException ex) {
			System.out.println("SQLException Fechar conexao: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
