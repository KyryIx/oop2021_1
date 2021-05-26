package Objetos;
public class Nota {
	private int codigo;
	private float valor;
	private float peso;
	
	public Nota() {
		this.valor = 0.0f;
		this.valor = 0.0f;
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
	
	public String toString() {
		return this.getValor() + "/" + this.getPeso();
	}
}
