public class Aluno extends Pessoa {
	private String telefone;

	public Aluno() {
		// isso
		super(); // chama o construtor da classe mae
		this.telefone = "";

		/* ou isso
		this.setNome(""); // this.nome =
		this.setSobrenome("");
		this.setIdade(0);
		this.setId(0);
		this.telefone = "";*/
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone( String telefone ) {
		this.telefone = telefone;
	}
	
	public String toString() {
		return super.toString() + "/" +
			   this.getTelefone() + "/";
		
		// Teste aqui
	}
}
