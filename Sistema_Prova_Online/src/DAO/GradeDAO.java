package DAO;
import java.util.ArrayList;

import Objetos.Disciplina;
import Objetos.Grade;

public interface GradeDAO {
	public boolean inserirGrade(Grade grade);
	public boolean atualizarGrade(Grade grade);
	public boolean excluirGrade(Grade grade);
	public Grade consultarGrade(int codigo);
	public ArrayList<Grade> consultarGrade( ArrayList<Disciplina> disciplinas );
	public ArrayList<Grade> listarGrades();
}
