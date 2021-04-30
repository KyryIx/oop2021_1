import java.util.ArrayList;
import java.util.Date;

// "final" -> nao permite criacao de classes filhas
public final class Sistema {
	public static void main(String[] args) {
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
		
//		/////// DEFINICAO DO ALUNO PARA A AVALIACAO 1 /////////
		Aluno aluno1 = new Aluno();
		aluno1.setId( 1668730 );
		aluno1.setNome( "Paulo" );
		aluno1.setSobrenome( "Rodrigues" );
		aluno1.setIdade( 18 );
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo( "PRO123" );
		disciplina.setEmenta( "Técnicas de programação Orientada a objetos. Tecnologias orientadas a objetos." );
		disciplina.setNome( "Projeto Orientado a Objetos" );
		disciplina.setSemestre( "6 semestre" );
		aluno1.setDisciplina( disciplina );
		
		Turma turma1 = new Turma();
		turma1.setCodigo( 4516 );
		
		Curso curso = new Curso();
		curso.setCodigo( 5464984 );
		curso.setNome( "Sistemas de Informação" );
		
		turma1.setCurso( curso );
		
		aluno1.setTurma( turma1 );
		aluno1.insertData();
		
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
		
		BancoDados banco = new BancoDados();
		banco.persist(aluno1);
		banco.persist(professor);
	}

}
