package Objetos;
import java.util.ArrayList;

public class Questao {
	private int codigo;
	private float valor;
	private float peso;
	private String descricao;
	private ArrayList<String> respostas;
	private int indiceRespostaCorreta;
	
	public Questao() {
		this.peso = 0.0f;
		this.descricao = "";
		this.respostas = new ArrayList<String>();
		this.indiceRespostaCorreta = 0;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public ArrayList<String> getRespostas() {
		return respostas;
	}
	
	public void setRespostas(ArrayList<String> respostas) {
		this.respostas = respostas;
	}
	
	public int getIndiceRespostaCorreta() {
		return indiceRespostaCorreta;
	}
	
	public void setIndiceRespostaCorreta(int indiceRespostaCorreta) {
		this.indiceRespostaCorreta = indiceRespostaCorreta;
	}
	
	public boolean isRepostaCorreta( int indiceResposta ) {
		if( this.indiceRespostaCorreta == indiceResposta ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public float valorResposta( int indiceResposta ) {
		if( this.indiceRespostaCorreta == indiceResposta ) {
			return this.getPeso() * this.getValor();
		}
		else {
			return 0.0f;
		}
	}
}
