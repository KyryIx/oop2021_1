package DAO;
import java.util.ArrayList;

import Objetos.Aluno;

public interface AlunoDAO {
	public boolean inserirAluno(Aluno aluno);
	public boolean atualizarAluno(Aluno aluno);
	public boolean excluirAluno(Aluno aluno);
	public Aluno consultarAluno(int codigo);
	public ArrayList<Aluno> consultarAluno(String nome, String sobrenome);
	public ArrayList<Aluno> listarAlunos();
}