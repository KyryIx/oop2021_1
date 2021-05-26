package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;

import Objetos.MySQL;
import Objetos.Questao;

public class QuestaoDAOMySQL implements QuestaoDAO {
	private MySQL mysql;
	
	public QuestaoDAOMySQL() {
		this.mysql = new MySQL();
	}

	@Override
	public boolean inserirQuestao(Questao questao) {
		String sql;
		sql  = "INSERT INTO ";
		sql += "questao(codigo,valor,peso,descricao,respostas,indiceRespostaCorreta)";
		sql += "VALUES(";
		sql += questao.getCodigo() + ", " + questao.getValor() + ", ";
		sql += questao.getPeso() + ", '" + questao.getDescricao() + "', ";
		
		JSONArray json = new JSONArray( questao.getRespostas().toArray() );
		
		sql += "'" + json.toString() + "', " + questao.getIndiceRespostaCorreta() + ")";
		
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean atualizarQuestao(Questao questao) {
		String sql;
		sql  = "UPDATE questao ";
		sql += "SET";
		sql += " valor = " + questao.getValor();
		sql += " peso = " + questao.getPeso();
		sql += " descricao = '" + questao.getDescricao() + "'";
		
		sql += " respostas = '";

		// https://github.com/stleary/JSON-java
		JSONArray json = new JSONArray( questao.getRespostas().toArray() );
		
		sql += json.toString() + "'";
		
		sql += " indiceRespostaCorreta = " + questao.getIndiceRespostaCorreta();
		
		sql += "WHERE codigo=" + questao.getCodigo();
		return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public boolean excluirQuestao(Questao questao) {
		String sql;
        sql  = "DELETE FROM questao ";
        sql += "WHERE codigo = " + questao.getCodigo();
        return (this.mysql.atualizar( sql ) > 0 ? true : false);
	}

	@Override
	public Questao consultarQuestao(int codigo) {
		Questao questao = new Questao();
		try {
			String sql = "SELECT * FROM questao WHERE codigo=" + codigo;
			
			if( this.mysql.consultar( sql ) ) {
				ResultSet rs = this.mysql.getRs();
				questao.setCodigo( codigo );
				questao.setValor( rs.getFloat( "valor" ) );
				questao.setPeso( rs.getFloat( "peso" ) );
				questao.setDescricao( rs.getString( "descricao" ) );
				
				JSONArray json = new JSONArray( rs.getString("respostas") );
				ArrayList<String> respostas = new ArrayList<String>();
				
				Iterator<Object> it = json.iterator();
				
				while( it.hasNext() ){
					respostas.add( it.next().toString() );
				}
				
				questao.setRespostas( respostas );
				
				questao.setIndiceRespostaCorreta( rs.getInt( "indiceRespostaCorreta" ) );
			}
		}
		catch (SQLException ex) {
			System.out.println( "SQLException Consultar Grade: " + ex.getMessage() );
		}
		
		this.mysql.clearRs();
		this.mysql.clearStmt();
		
		return questao;
	}

	@Override
	public ArrayList<Questao> consultarQuestao(Questao questao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Questao> listarQuestaos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fechar() {
		this.mysql.close();
	}
}
