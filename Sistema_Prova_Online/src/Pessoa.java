public abstract class Pessoa {
	private int codigo;
	private String nome;
	private String sobrenome;
	private int idade;
	
	public Pessoa() {
		this.nome = "";
		this.sobrenome = "";
		this.idade = 0;
		this.codigo = 0;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setNome( String nome ) {
		this.nome = nome;
	}
	
	public void setSobrenome( String sobrenome ) {
		this.sobrenome = sobrenome;
	}
	
	public void setIdade( int idade ) {
		this.idade = idade;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo( int codigo ) {
		this.codigo = codigo;
	}

	public String toString() {
		return this.getNome() + "/" +
			   this.getSobrenome() + "/" +
			   this.getIdade() + "/" +
			   this.getCodigo() + "/";
	}
}
