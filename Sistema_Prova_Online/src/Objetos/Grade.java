package Objetos;
import java.util.ArrayList;

public class Grade {
	private int codigo;
	private ArrayList<ArrayList<Disciplina>> disciplinas;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<ArrayList<Disciplina>> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(ArrayList<ArrayList<Disciplina>> disciplinas) {
		this.disciplinas = disciplinas ;
	}
}