import java.util.ArrayList;

public class Questao {
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
	
	public int getIndireRespostaCorreta() {
		return indiceRespostaCorreta;
	}
	
	public void setIndireRespostaCorreta(int indireRespostaCorreta) {
		this.indiceRespostaCorreta = indireRespostaCorreta;
	}
}
