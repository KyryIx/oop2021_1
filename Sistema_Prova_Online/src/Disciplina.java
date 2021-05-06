public class Disciplina {
	private int codigo;
	private String nome;
	private String ementa;
	private String semestre;
	
	public Disciplina() {
		this.codigo = 0;
		this.nome = "";
		this.ementa = "";
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
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
	
	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	public String toString() {
		return this.getCodigo() + "/" +
	           this.getSemestre() + "/" +
			   this.getNome() + "/" +
			   this.getEmenta();
	}
}
