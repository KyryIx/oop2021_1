public class Nota {
	private float valor;
	private float peso;
	
	public Nota() {
		this.valor = 0.0f;
		this.valor = 0.0f;
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
