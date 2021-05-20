package Objetos;
public class Professor extends Pessoa {
	private Disciplina disciplina;
	private Turma turma;
	
	public Professor() {
		//////////////////////////////////////////////////
		// super() chama o construtor da classe mae     //
		// no qual inicializa os valores dos atribuitos //
		// herdados da classe mae                       //
		//////////////////////////////////////////////////
		super();
		this.disciplina = new Disciplina();
		this.turma = new Turma();
	}
	
	public Disciplina getDisciplina() {
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
		return super.toString() + "/" + this.getTurma().toString();
	}
}
