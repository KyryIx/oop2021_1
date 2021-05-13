import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// procedimento obtido em:
// https://dev.mysql.com/doc/connector-j/5.1/en/connect
// or-j-usagenotes-connect-drivermanager.html

public class BancoDados {
	private String host = "localhost";
	private String database = "test"; // schema = database
	private String user = "root";
	private String password = "root";
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;

	public BancoDados() {
		String strConn = "jdbc:mysql://" + this.host + "/" + this.database + "?" + "user=" + this.user + "&password="
				+ this.password;
		try {
			conn = DriverManager.getConnection(strConn);
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public String getHost() {
		return host;
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

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
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

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	public void clearRs() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {}

			rs = null;
		}
	}

	private void atualizar(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate( sql );
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} finally {
			this.clearRs();
			this.clearStmt();
		}
	}
	
	private void consultar(String sql) {
		try {
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery( sql );
			if( rs.next() ) {
				return;
			}
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    this.clearRs();
		    this.clearStmt();
		}
	}

	public void inserirAluno(Aluno aluno) {
		String sql;
		sql  = "INSERT INTO aluno(codigo, nome, sobrenome, idade, fk_disciplina, fk_turma)";
		sql += "VALUES(" + aluno.getCodigo() + ", '" + aluno.getNome() + "','";
		sql += aluno.getSobrenome() + "',";
		sql += aluno.getIdade() + ", " + aluno.getDisciplina().getCodigo() + ", ";
		sql += aluno.getTurma().getCodigo() + ")";
		this.atualizar( sql );
	}
	
	public void atualizarAluno(Aluno aluno) {
		String sql;
		sql  = "UPDATE aluno ";
		sql += "SET ";
		sql += "nome='" + aluno.getNome() + "', ";
		sql += "sobrenome='" + aluno.getSobrenome() + "', ";
		sql += "idade=" + aluno.getIdade() + ", ";
		sql += "fk_disciplina="+ aluno.getDisciplina().getCodigo() + ", ";
		sql += "fk_turma=" + aluno.getTurma().getCodigo() + " ";
		sql += "WHERE codigo=" + aluno.getCodigo();
		this.atualizar( sql );
	}
	
	public void excluirAluno(Aluno aluno) {
		// implementar //
	}
	
	public Aluno consultarAluno(int codigo) {
		Aluno aluno = new Aluno();
		consultar( "SELECT * FROM aluno WHERE codigo=" + codigo );
		try {
			if( this.rs != null ) {
				aluno.setCodigo( codigo );
				aluno.setNome( rs.getString("nome") );
				aluno.setSobrenome( rs.getString("sobrenome") );
				aluno.setIdade( rs.getInt("idade") );
				// criar um objeto disciplina e pesquisar na base a disciplina com esse codigo "rs.getInt("fk_disciplina")"
				//aluno.setDisciplina(  );
				// criar um objeto turma e pesquisar na base a turma com esse codigo "rs.getInt("fk_turma")"
				//aluno.setTurma(  );
			}
		}
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		this.clearRs();
		this.clearStmt();
		
		return aluno;
	}
	
	public void inserirDisciplina(Disciplina disciplina) {
		String sql;
		sql  = "INSERT INTO disciplina(codigo, nome, ementa)";
		sql += "VALUES('" + disciplina.getCodigo() + "','" + disciplina.getNome() + "','";
		sql += disciplina.getEmenta() + "')";
		this.atualizar( sql );
	}
	
	public void atualizarDisciplina(Disciplina disciplina) {
        String sql;
        sql  = "UPDATE disciplina ";
        sql += "SET ";
        sql += "nome='" + disciplina.getNome() + "', ";
        sql += "ementa='" + disciplina.getEmenta() + "', ";
        sql += "WHERE codigo=" + disciplina.getCodigo();
        this.atualizar( sql );
    }
	
	public void excluirDisciplina(Disciplina disciplina) {
        String sql;
        sql  = "DELETE FROM disciplina WHERE ";
        sql += "disciplina.codigo = " + disciplina.getCodigo();
        this.atualizar(sql);        
    }
	
	public Disciplina consultarDisciplina(int codigo) {
        Disciplina disciplina = new Disciplina();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM disciplina WHERE codigo=" + codigo; 
            rs = stmt.executeQuery( sql );
            if( rs.next() ) {
                disciplina.setCodigo( codigo );
                disciplina.setNome( rs.getString("nome") );
                disciplina.setEmenta( rs.getString("ementa") );
            }
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
        
        return disciplina;
    }
	
	public void inserirTurma(Turma turma) {
		String sql;
		sql  = "INSERT INTO turma(fk_curso)";
		sql += "VALUES(" + turma.getCurso().getCodigo() + ")";
		this.atualizar( sql );
	}
	
	public void atualizarTurma(Turma turma) {
        String sql;
        sql  = "UPDATE turma ";
        sql += "SET ";
        sql += "fk_curso="+ turma.getCurso().getCodigo() + ", ";
        sql += "WHERE codigo=" + turma.getCodigo();
        this.atualizar( sql );
    }
    
    public void excluirTurma(Turma turma) {
        String sql;
        sql  = "DELETE FROM turma WHERE ";
        sql += "turma.codigo = " + turma.getCodigo();
        this.atualizar(sql);        
    }
    
    public Turma consultarTurma(int codigo) {
        Turma turma = new Turma();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM turma WHERE codigo=" + codigo; 
            rs = stmt.executeQuery( sql );
            if( rs.next() ) {
                turma.setCodigo( codigo );
            }
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
        
        return turma;
    }
}
