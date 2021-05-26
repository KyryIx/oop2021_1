package DAO;

import java.util.ArrayList;

import Objetos.Nota;

public interface NotaDAO {
	public boolean inserirNota(Nota nota);
	public boolean atualizarNota(Nota nota);
	public boolean excluirNota(Nota nota);
	public Nota consultarNota(int codigo);
	public ArrayList<Nota> consultarNota(String nome);
	public ArrayList<Nota> listarNotas();
}