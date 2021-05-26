package DAO;

import java.util.ArrayList;
import java.util.Calendar;

import Objetos.Aluno;
import Objetos.Avaliacao;
import Objetos.Curso;
import Objetos.Disciplina;
import Objetos.Professor;
import Objetos.Turma;

public interface AvaliacaoDAO {
	public boolean inserirAvaliacao(Avaliacao avaliacao);
	public boolean atualizarAvaliacao(Avaliacao avaliacao);
	public boolean excluirAvaliacao(Avaliacao avaliacao);
	public Avaliacao consultarAvaliacao(int codigo);
	public ArrayList<Avaliacao> consultarAvaliacao(Aluno aluno);
	public ArrayList<Avaliacao> consultarAvaliacao(Turma turma);
	public ArrayList<Avaliacao> consultarAvaliacao(Disciplina disciplina);
	public ArrayList<Avaliacao> consultarAvaliacao(Professor professor);
	public ArrayList<Avaliacao> consultarAvaliacao(Curso curso);
	public ArrayList<Avaliacao> consultarAvaliacao(Calendar dataAvaliacao);
	public ArrayList<Avaliacao> listarAvaliacoes();
}
