package DAO;
import java.util.ArrayList;

import Objetos.Curso;
import Objetos.Turma;

public interface TurmaDAO {
	public boolean inserirTurma(Turma turma);
	public boolean atualizarTurma(Turma turma);
	public boolean excluirTurma(Turma turma);
	public Turma consultarTurma(int codigo);
	public ArrayList<Turma> consultarTurma(Curso curso );
	public ArrayList<Turma> listarTurmas();
}
