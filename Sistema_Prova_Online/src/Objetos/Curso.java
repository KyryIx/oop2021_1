package Objetos;
public class Curso {
	private int codigo;
	private String nome;
	private Grade grade;
	
	public Curso() {
		this.codigo = 0;
		this.nome = "";
		this.grade = new Grade();
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
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
