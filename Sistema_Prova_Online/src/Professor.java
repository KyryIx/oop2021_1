import java.util.ArrayList;

public class Professor extends Pessoa {
	private ArrayList<String> turmas;
	
	public Professor() {
		super();
		this.turmas.clear();
	}

	public ArrayList<String> getTurmas() {
		return turmas;
	}

	public void setTurmas(ArrayList<String> turmas) {
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
