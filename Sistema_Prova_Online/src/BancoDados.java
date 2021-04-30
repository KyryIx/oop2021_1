import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// procedimento obtido em:
// https://dev.mysql.com/doc/connector-j/5.1/en/connect
// or-j-usagenotes-connect-drivermanager.html

public class BancoDados {
	private String host     = "localhost";
	private String database = "test"; // schema = database
	private String user     = "root";
	private String password = "root";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;
	
	public BancoDados() {
		String strConn = "jdbc:mysql://" + 
				         this.host + "/" + this.database +
				         "?" + "user=" + this.user +
				         "&password=" + this.password;
		try {
			conn = DriverManager.getConnection( strConn );
			stmt = conn.createStatement();
			rs = stmt.executeQuery( "SELECT id FROM pessoa" );
			
			String sql = "INSERT INTO pessoa(" +
			             "nome, sobrenome, idade)" +
			             "VALUES('Luiz','Pereira',18)";
			stmt.executeUpdate( sql );
			
			rs = stmt.executeQuery( "SELECT id FROM pessoa" );
			
			rs.next();
			System.out.println( "ID:" + rs.getInt(1) );
			System.out.println( "ID:" + rs.getInt("id") );
			
			int a = 6;
			int b = a + 1;
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        }
		        catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}
	
	public boolean persist( Aluno aluno ) {
		return true;
	}
	
	public boolean persist( Professor professor ) {
		return true;
	}
	
	public boolean insertRegister( String sql ) {
		boolean state = false;
		String strConn = "jdbc:mysql://" + 
		         this.host + "/" + this.database +
		         "?" + "user=" + this.user +
		         "&password=" + this.password;
		try {
			conn = DriverManager.getConnection( strConn );
			stmt = conn.createStatement();
			stmt.executeUpdate( sql );
			state = true;
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			state = false;
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (SQLException sqlEx) { } // ignore
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) { } // ignore
			    stmt = null;
			}
		}
		return state;
	}
}
