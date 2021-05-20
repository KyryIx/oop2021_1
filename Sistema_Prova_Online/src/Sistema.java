import java.util.ArrayList;

import DAO.AlunoDAOMySQL;
import DAO.CursoDAOMySQL;
import DAO.DisciplinaDAOMySQL;
import DAO.GradeDAOMySQL;
import DAO.ProfessorDAOMySQL;
import DAO.TurmaDAOMySQL;
import Objetos.Aluno;
import Objetos.Curso;
import Objetos.Disciplina;
import Objetos.Grade;
import Objetos.Professor;
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
		semestresTipo1.add( new ArrayList<Disciplina>() );
		semestresTipo1.get(0).set(0, disciplina1);
		semestresTipo1.get(0).set(1, disciplina2);
		
		grade1.setDisciplinas( semestresTipo1 );
		
		gradeDaoMySQL.inserirGrade( grade1 );
		
		Grade grade2 = new Grade();
		grade2.setCodigo( 8548 );
		
		// Formato -> dois semestres com apenas uma disciplina em cada semestre (15245, 15328)
		ArrayList<ArrayList<Disciplina>> semestresTipo2 = new ArrayList<ArrayList<Disciplina>>();
		semestresTipo1.add( new ArrayList<Disciplina>() );
		semestresTipo1.get(0).add(disciplina1);
		semestresTipo1.get(0).add(disciplina2);
		
		grade1.setDisciplinas( semestresTipo2 );
		
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
		
		
		
	/*	
		Avaliacao avaliacao1 = new Avaliacao();
		
		///////// DEFINICAO DAS QUESTOES DA AVALIACAO 1 ///////// 
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		
		Questao questao = new Questao();
		questao.setPeso( 1.0f );
		questao.setDescricao( "Qual o resultado da expressao 1 + 1?" );
		ArrayList<String> respostas = new ArrayList<String>();
		respostas.add( "10" );
		respostas.add( "2" );
		respostas.add( "0" );
		respostas.add( "1" );
		respostas.add( "Nenhumas das anteriores" );
		questao.setRespostas( respostas );
		questao.setIndireRespostaCorreta( 1 );
		questoes.add( questao );
		
		questao = new Questao();
		questao.setPeso( 3.0f );
		questao.setDescricao( "Qual a cor branca do cavalo de Napoleão?" );
		respostas = new ArrayList<String>();
		respostas.add( "Branco" );
		respostas.add( "Preto" );
		respostas.add( "Marrom" );
		respostas.add( "Azul escuro" );
		respostas.add( "Nenhumas das anteriores" );
		questao.setRespostas( respostas );
		questao.setIndireRespostaCorreta( 2 );
		questoes.add( questao );
		
		avaliacao1.setQuestoes( questoes );
		
//		
		
		
		
		
		
		turma1.setCurso( curso );
		
		aluno1.setTurma( turma1 );
		//aluno1.insertData();
		
		avaliacao1.setAluno( aluno1 );
		avaliacao1.setTurma( turma1 );
		avaliacao1.setCurso( curso );
		avaliacao1.setDisciplina( disciplina );
		Date data = new Date( 2021,4,27,19,0 );
		avaliacao1.setDataAvaliacao( data );
		
		Professor professor = new Professor();
		professor.setId( 100100789 );
		professor.setNome( "Everton" );
		professor.setSobrenome( "Pereira" );
		professor.setIdade( 41 );
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		turmas.add( turma1 );
		professor.setTurmas( turmas );
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add( disciplina );
		professor.setDisciplinas( disciplinas );
		avaliacao1.setProfessor( professor );
		
		Nota nota = new Nota();
		nota.setPeso(  0.40f ); // 40% do semestre
		avaliacao1.setNota( nota );
		
		System.out.println( " NOME DO ALUNO: " +
				avaliacao1.getAluno().getNome() + " " +
				avaliacao1.getAluno().getSobrenome() );
		
		System.out.println( "    DISCIPLINA: " + 
		         avaliacao1.getAluno().getDisciplina().getNome() );
		
		System.out.println( "         CURSO: " +
		         avaliacao1.getCurso().getNome() );
		
		System.out.println( "     PROFESSOR: " + 
		         avaliacao1.getProfessor().getNome() );
		
		System.out.println( "          DATA: " + 
		         avaliacao1.getDataAvaliacao().getDay() + "/" +
				 avaliacao1.getDataAvaliacao().getMonth() + "/" +
		         avaliacao1.getDataAvaliacao().getYear() );
		
		System.out.println( "PESO AVALIACAO: " + 
		         (avaliacao1.getNota().getPeso()*100) + "%" );
		
		Nota av1 = avaliacao1.getNota();
		av1.setValor( 9.0f );
		avaliacao1.setNota( av1 );
		*/
		// ATIVIDADE PARA A CASA:
		// 1 - IMPLEMENTAR A EXIBICAO DAS QUESTOES
		// 2 - AO MESMO TEMPO QUE EXIBE UMA QUESTAO,
		//     PEDIR A RESPOSTA PARA DAR O RESULTADO
		//     SE ACERTOU OU ERRO. PARA ISSO USE O
		//     Scanner DO Java.
		
		/*
		 NOME DO ALUNO: Paulo Rodrigues
		    DISCIPLINA: Projeto Orientado a Objetos
		         CURSO: Sistemas de Informação
		     PROFESSOR: Everton
		          DATA: 5/4/2021
		PESO AVALIACAO: 40.0%
		
		Questao 1 - Qual o resultado da expressao 1 + 1?
		Alternatica 1 - Branco
		Alternatica 2 - Preto
		Alternatica 3 - Marrom
		Alternatica 4 - Azul escuro
		Alternatica 5 - Nenhumas das anteriores
		
		Digite o numero da alternativa e pressione ENTER: 2
		Resposta: INCORRETA (0.0 pontos)
		*/
		/*
		BancoDados banco = new BancoDados();
		banco.persist(aluno1);
		banco.persist(professor);
		*/
	}

}
