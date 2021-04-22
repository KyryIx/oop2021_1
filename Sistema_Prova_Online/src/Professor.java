import java.util.ArrayList;

public class Professor extends Pessoa {
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<Turma> turmas;
	
	public Professor() {
		super();
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public String toString() {
		int n = this.turmas.size();
		String str = "";
		for( int i=0; i<n; i++ ) {
			str += this.turmas.get(i) + " ";
		}
		return super.toString() + "/" + str;
	}
}
