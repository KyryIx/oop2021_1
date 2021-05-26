import java.util.ArrayList;
import java.util.Calendar;

import DAO.AlunoDAOMySQL;
import DAO.CursoDAOMySQL;
import DAO.DisciplinaDAOMySQL;
import DAO.GradeDAOMySQL;
import DAO.NotaDAOMySQL;
import DAO.ProfessorDAOMySQL;
import DAO.QuestaoDAOMySQL;
import DAO.TurmaDAOMySQL;
import Objetos.Aluno;
import Objetos.Avaliacao;
import Objetos.Curso;
import Objetos.Disciplina;
import Objetos.Grade;
import Objetos.Nota;
import Objetos.Professor;
import Objetos.Questao;
import Objetos.Turma;

// "final" -> nao permite criacao de classes filhas
public final class Sistema {
	
	public static void main(String[] args) {
		/////////////////////////////////////////////////////////////////////////////////
		///////////////// INSERCAO DE DISCIPLINAS NO SISTEMA ////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		DisciplinaDAOMySQL disciplinaDaoMySQL = new DisciplinaDAOMySQL();
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setCodigo( 15245 );
		disciplina1.setNome( "Projeto Orientado a Objetos" );
		disciplina1.setEmenta( "Técnicas de programação Orientada a objetos. Tecnologias orientadas a objetos." );
		
		disciplinaDaoMySQL.inserirDisciplina( disciplina1 );
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setCodigo( 15328 );
		disciplina2.setNome( "Programação WEB" );
		disciplina2.setEmenta( "Programação de páginas WEB, aplicação de estilos e tratamento de informações enviadas por formulários." );
		
		disciplinaDaoMySQL.inserirDisciplina( disciplina2 );
		
		disciplinaDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DE GRADE NO SISTEMA //////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		GradeDAOMySQL gradeDaoMySQL = new GradeDAOMySQL();
		
		Grade grade1 = new Grade();
		grade1.setCodigo( 8531 );
		
		// Formato -> apenas um semestre com duas disciplinas (15245, 15328) no mesmo semestres
		ArrayList<ArrayList<Disciplina>> semestresTipo1 = new ArrayList<ArrayList<Disciplina>>();
		semestresTipo1.add( new ArrayList<Disciplina>() );
		semestresTipo1.get(0).add(disciplina1);
		semestresTipo1.get(0).add(disciplina2);
		
		grade1.setDisciplinas( semestresTipo1 );
		
		gradeDaoMySQL.inserirGrade( grade1 );
		
		Grade grade2 = new Grade();
		grade2.setCodigo( 8548 );
		
		// Formato -> dois semestres com apenas uma disciplina em cada semestre (15245, 15328)
		ArrayList<ArrayList<Disciplina>> semestresTipo2 = new ArrayList<ArrayList<Disciplina>>();
		semestresTipo2.add( new ArrayList<Disciplina>() );
		semestresTipo2.add( new ArrayList<Disciplina>() );
		semestresTipo2.get(0).add(disciplina1);
		semestresTipo2.get(1).add(disciplina2);
		
		grade2.setDisciplinas( semestresTipo2 );
		
		gradeDaoMySQL.inserirGrade( grade2 );
		
		gradeDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DE CURSO NO SISTEMA //////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		CursoDAOMySQL cursoDaoMySQL = new CursoDAOMySQL();
		
		Curso curso1 = new Curso();
		curso1.setCodigo( 481 );
		curso1.setNome( "Sistema de Informação" );
		curso1.setGrade(grade2);
		
		cursoDaoMySQL.inserirCurso( curso1 );
		
		cursoDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DA TURMA NO SISTEMA //////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		TurmaDAOMySQL turmaDaoMySQL = new TurmaDAOMySQL();
		
		Turma turma1 = new Turma();
		turma1.setCodigo( 4516 );
		turma1.setCurso( curso1 );
		
		turmaDaoMySQL.inserirTurma( turma1 );
		
		turmaDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DO PROFESSOR NO SISTEMA //////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		ProfessorDAOMySQL ProfessorDaoMySQL = new ProfessorDAOMySQL();
		
		Professor professor1 = new Professor();
		professor1.setCodigo( 100100789 );
		professor1.setNome( "Everton" );
		professor1.setSobrenome( "Pereira" );
		professor1.setIdade( 41 );
		professor1.setDisciplina( disciplina1 );
		professor1.setTurma( turma1 );
		
		ProfessorDaoMySQL.inserirProfessor( professor1 );
		
		ProfessorDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DO PROFESSOR NO SISTEMA //////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		AlunoDAOMySQL alunoDaoMySQL = new AlunoDAOMySQL();
		
		Aluno aluno1 = new Aluno();
		aluno1.setCodigo( 1668740 );
		aluno1.setNome( "Paulo" );
		aluno1.setSobrenome( "Rodrigues" );
		aluno1.setIdade( 18 );
		aluno1.setDisciplina( disciplina1 );
		aluno1.setTurma( turma1 );
		
		alunoDaoMySQL.inserirAluno( aluno1 );
		
		alunoDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DAS QUESTOES NO SISTEMA //////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		QuestaoDAOMySQL questaoDaoMySQL = new QuestaoDAOMySQL();
		
		Questao questao1 = new Questao();
		questao1.setCodigo( 1564 );
		questao1.setValor( 1.0f );
		questao1.setPeso( 1.0f );
		questao1.setDescricao( "Qual o resultado da expressao 1 + 1?" );
		ArrayList<String> respostas = new ArrayList<String>();
		respostas.add( "10" );
		respostas.add( "2" );
		respostas.add( "0" );
		respostas.add( "1" );
		respostas.add( "Nenhumas das anteriores" );
		questao1.setRespostas( respostas );
		questao1.setIndiceRespostaCorreta( 1 );
		
		questaoDaoMySQL.inserirQuestao( questao1 );
		
		Questao questao2 = new Questao();
		questao2.setCodigo( 1565 );
		questao2.setValor( 1.5f );
		questao2.setPeso( 1.0f );
		questao2.setDescricao( "Qual a cor branca do cavalo de Napoleão?" );
		respostas = new ArrayList<String>();
		respostas.add( "Branco" );
		respostas.add( "Preto" );
		respostas.add( "Cinza" );
		respostas.add( "Azul escuro" );
		respostas.add( "Nenhumas das anteriores" );
		questao2.setRespostas( respostas );
		questao2.setIndiceRespostaCorreta( 2 );
		
		questaoDaoMySQL.inserirQuestao( questao2 );
		
		questaoDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DAS NOTAS NO SISTEMA /////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		NotaDAOMySQL notaDaoMySQL = new NotaDAOMySQL();
		
		Nota nota1 = new Nota();
		nota1.setCodigo( 46164 );
		nota1.setValor( 0.0f ); // pois o aluno ainda nao fez a prova
		nota1.setPeso( 100.0f );
		
		notaDaoMySQL.inserirNota( nota1 );
		
		notaDaoMySQL.fechar();
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DA AVALIACAO NO SISTEMA //////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		Avaliacao avaliacao1 = new Avaliacao();
		avaliacao1.setCodigo( 876167 );
		avaliacao1.setAluno( aluno1 );
		avaliacao1.setProfessor( professor1 );
		avaliacao1.setDisciplina( disciplina1 );
		avaliacao1.setTurma( turma1 );
		avaliacao1.setNota( nota1 );
		
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		questoes.add( questao1 );
		questoes.add( questao2 );
		
		avaliacao1.setQuestoes( questoes );
		
		// https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401
		Calendar date = Calendar.getInstance();
		date.set(2021, Calendar.JUNE, 14 );
		avaliacao1.setDataAvaliacao( date );
		
		avaliacao1.setCurso( curso1 );
		
		/////////////////////////////////////////////////////////////////////////////////
		///////////////////// INSERCAO DA AVALIACAO NO SISTEMA //////////////////////////
		/////////////////////////////////////////////////////////////////////////////////
		avaliacao1.executarAvaliacao();
	}

}
