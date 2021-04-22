public class Curso {
	private String nome;
	//private Grade grade;
	private int codigo;
	
	public Curso() {
		this.nome = "";
		//this.grade = new Grade();
		this.codigo = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*public Grade getGrade() {
		return grade;
	}*/
	
	/*public void setGrade(Grade grade) {
		this.grade = grade;
	}*/
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
