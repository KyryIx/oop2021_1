public class Disciplina {
	private String codigo;
	private String nome;
	private String ementa;
	private String semestre;
	
	public Disciplina() {
		this.codigo = "";
		this.nome = "";
		this.ementa = "";
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmenta() {
		return ementa;
	}
	
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	public String toString() {
		return this.getCodigo() + "/" +
			   this.getNome() + "/" +
			   this.getEmenta();
	}
}
