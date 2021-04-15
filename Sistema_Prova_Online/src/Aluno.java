public class Aluno extends Pessoa {
	private Disciplina disciplina;
	private Turma turma;

	public Aluno() {
		// isso
		super(); // chama o construtor da classe mae
		this.disciplina = new Disciplina();
		this.turma = new Turma();

		/* ou isso
		this.setNome(""); // this.nome =
		this.setSobrenome("");
		this.setIdade(0);
		this.setId(0);
		*/
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
}
