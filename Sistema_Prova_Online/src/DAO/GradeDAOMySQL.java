package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;

import Objetos.Disciplina;
import Objetos.Grade;
import Objetos.MySQL;

// https://www.json.org/json-en.html
// https://github.com/stleary/JSON-java
// https://dev.mysql.com/doc/refman/8.0/en/json.html

public class GradeDAOMySQL implements GradeDAO {
	private MySQL mysql;
	
	public GradeDAOMySQL() {
		this.mysql = new MySQL();
	}

	@Override
	public boolean inserirGrade(Grade grade) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "grade(codigo, fk_disciplinas)";
		sql += "VALUES(";
		sql += grade.getCodigo() + ", '";
		
		// https://github.com/stleary/JSON-java
		JSONArray json = new JSONArray();
		int n = grade.getDisciplinas().size();
		int m = 0;
		for( int i=0; i<n; i++ ) {
			JSONArray jsonTemp = new JSONArray();
			m = grade.getDisciplinas().get(i).size();
			for( int j=0; j<m; j++ ) {
				jsonTemp.put( grade.getDisciplinas().get(i).get(j).getCodigo() );
			}
			json.put(jsonTemp);
		}
		
		sql += json.toString() + "')";
				
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarGrade(Grade grade) {
		String sql;
		sql  = "UPDATE grade ";
		sql += "SET ";
		sql += "disciplinas='";
		
		// https://github.com/stleary/JSON-java
		JSONArray json = new JSONArray();
		int n = grade.getDisciplinas().size();
		int m = 0;
		for( int i=0; i<n; i++ ) {
			JSONArray jsonTemp = new JSONArray();
			m = grade.getDisciplinas().get(i).size();
			for( int j=0; j<m; j++ ) {
				jsonTemp.put( grade.getDisciplinas().get(i).get(j).getCodigo() );
			}
			json.put(jsonTemp);
		}
				
		sql += json.toString() + "'";
		
		sql += "WHERE codigo=" + grade.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirGrade(Grade grade) {
		String sql;
        sql  = "DELETE FROM grade ";
        sql += "WHERE codigo = " + grade.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Grade consultarGrade(int codigo) {
		Grade grade = new Grade();
		try {
			String sql = "SELECT * FROM grade WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				grade.setCodigo( codigo );
				
				DisciplinaDAOMySQL disciplinaDAO = new DisciplinaDAOMySQL();
				ArrayList<ArrayList<Disciplina>> disciplinas = new ArrayList<ArrayList<Disciplina>>();
				
				// https://github.com/stleary/JSON-java
				JSONArray json = new JSONArray( rs.getString("fk_disciplinas") );
				int n = json.length();
				for( int i=0; i<n; i++ ) {
					int m = json.getJSONArray(i).length();
					ArrayList<Disciplina> disciplinasTemp = new ArrayList<Disciplina>();
					for( int j=0; j<m; j++ ) {
						disciplinasTemp.add( disciplinaDAO.consultarDisciplina( json.getJSONArray(i).getInt(j) ) );
					}
					disciplinas.add( disciplinasTemp );
				}
				
				grade.setDisciplinas( disciplinas );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Grade: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return grade;
	}

	@Override
	public ArrayList<Grade> consultarGrade(ArrayList<Disciplina> disciplinas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Grade> listarGrades() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fechar() {
		this.mysql.close();
	}

}
