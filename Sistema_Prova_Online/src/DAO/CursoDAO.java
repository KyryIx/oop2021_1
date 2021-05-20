package DAO;

import java.util.ArrayList;

import Objetos.Curso;

public interface CursoDAO {
	public boolean inserirCurso(Curso curso);
	public boolean atualizarCurso(Curso curso);
	public boolean excluirCurso(Curso curso);
	public Curso consultarCurso(int codigo);
	public ArrayList<Curso> consultarCurso(String nome);
	public ArrayList<Curso> listarCursos();
}
