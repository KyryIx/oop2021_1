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
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public void inserirAluno( Aluno aluno ){
		try {
			stmt = conn.createStatement();
			String sql;
			sql  = "INSERT INTO aluno(nome, sobrenome, idade, fk_disciplina, fk_turma)";
			sql += "VALUES('" + aluno.getNome() + "','" + aluno.getSobrenome() + "',";
			sql += aluno.getIdade() + ", " + aluno.getDisciplina().getCodigo() + ", ";
			sql += aluno.getTurma().getCodigo() + ")";
			stmt.executeUpdate( sql );
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
}
