package DAO;
import java.util.ArrayList;

import Objetos.Professor;

public interface ProfessorDAO {
	public boolean inserirProfessor(Professor professor);
	public boolean atualizarProfessor(Professor professor);
	public boolean excluirProfessor(Professor professor);
	public Professor consultarProfessor(int codigo);
	public ArrayList<Professor> consultarProfessor(String nome, String sobrenome);
	public ArrayList<Professor> listarProfessores();
}
