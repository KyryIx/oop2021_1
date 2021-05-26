package DAO;

import java.util.ArrayList;

import Objetos.Questao;

public interface QuestaoDAO {
	public boolean inserirQuestao(Questao questao);
	public boolean atualizarQuestao(Questao questao);
	public boolean excluirQuestao(Questao questao);
	public Questao consultarQuestao(int codigo);
	public ArrayList<Questao> consultarQuestao(Questao questao);
	public ArrayList<Questao> listarQuestaos();
}
