package Objetos;
public class Aluno extends Pessoa {
	private Disciplina disciplina;
	private Turma turma;

	public Aluno() {
		//////////////////////////////////////////////////
		// super() chama o construtor da classe mae     //
		// no qual inicializa os valores dos atribuitos //
		// herdados da classe mae                       //
		//////////////////////////////////////////////////
		super();
		this.disciplina = new Disciplina();
		this.turma = new Turma();
	}
	
	public Disciplina getDisciplina(){
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String toString() {
		return this.getCodigo() + "/" + this.getNome() + "/" +
	           this.getSobrenome() + "/" + this.getIdade();
	}
}
