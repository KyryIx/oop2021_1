package DAO;
import java.util.ArrayList;

import Objetos.Disciplina;

public interface DisciplinaDAO {
	public boolean inserirDisciplina(Disciplina disciplina);
	public boolean atualizarDisciplina(Disciplina disciplina);
	public boolean excluirDisciplina(Disciplina disciplina);
	public Disciplina consultarDisciplina(int codigo);
	public ArrayList<Disciplina> consultarDisciplina(String nome);
	public ArrayList<Disciplina> listarDisciplinas();
}
