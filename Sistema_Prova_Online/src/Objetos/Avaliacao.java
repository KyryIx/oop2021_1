package Objetos;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import DAO.AvaliacaoDAOMySQL;

public class Avaliacao {
	private int codigo;
	private Aluno aluno;
	private Turma turma;
	private Disciplina disciplina;
	private Professor professor;
	private Curso curso;
	// https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
	private Calendar dataAvaliacao;
	private ArrayList<Questao> questoes;
	private int[] respostas;
	private Nota nota;
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo( int codigo ) {
		this.codigo = codigo;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}
	
	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}
	
	public ArrayList<Questao> getQuestoes() {
		return questoes;
	}
	
	public void setQuestoes(ArrayList<Questao> questoes) {
		this.questoes = questoes;
	}
	
	public int[] getRespostas() {
		return this.respostas;
	}
	
	public void setRespostas(int[] respostas) {
		this.respostas = respostas;
	}
	
	public Nota getNota() {
		return nota;
	}
	
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	public void executarAvaliacao() {
		// TO DO //
		System.out.println( " NOME DO ALUNO: " + this.getAluno().getNome() + " " + this.getAluno().getSobrenome() );
		System.out.println( "    DISCIPLINA: " + this.getDisciplina().getNome() );
		System.out.println( "         CURSO: " + this.getCurso().getNome() );
		System.out.println( "     PROFESSOR: " + this.getProfessor().getNome() + " " + this.getProfessor().getSobrenome() );
		System.out.println( "          DATA: " + this.getDataAvaliacao().get(Calendar.DAY_OF_MONTH)
															+ "/" + this.getDataAvaliacao().get(Calendar.MONTH)
															+ "/" + this.getDataAvaliacao().get(Calendar.YEAR) );
		System.out.println( "PESO AVALIACAO: " + this.getNota().getPeso() + "%\n" );
		
		// https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
		try( Scanner scanner = new Scanner( System.in ) ){
			ArrayList<Questao> questoes = this.getQuestoes();
			int n = questoes.size();
			this.respostas = new int[n];
			ArrayList<String> respostas;
			
			for( int i=0; i<n; i++ ) {
				String estrutura;
				estrutura  =         "+---\n";
				estrutura +=         "| Questao " + (i+1) + " - " + questoes.get(i).getDescricao() + "\n";
				estrutura +=         "|\n";
				estrutura +=         "| Alternativas:\n";
				
				if( this.respostas[i] == 0 ) {
					respostas = questoes.get(i).getRespostas();
					
					int m = respostas.size();
					for( int j=0; j<m; j++ ) {
						estrutura += "| " + (j+1) + " - para a resposta: " + respostas.get(j) + "\n";
					}
					
					System.out.print( "Sua resposta (sendo um número de 1 a " + m + ") é : " );
					
					//this.respostas[i] = scanner.nextInt();
					
					
					if( questoes.get(i).getIndiceRespostaCorreta() == (this.respostas[i]-1) ) {
						System.out.println( "Voce acertou a questao." );
					}
					else {
						System.out.println( "Que pena, mas voce não acertou a questao." );
					}
				}
				else {
					estrutura +=     "| Você já respondeu essa questao e a resposta foi: " + this.getRespostas()[i] + "\n";
				}
				
				estrutura +=         "|\n";
				
				System.out.println( estrutura );
				System.out.println( "==================================================" );
			}
		}
		
		AvaliacaoDAOMySQL avaliacaoDAOMySQL = new AvaliacaoDAOMySQL();
		
		if( avaliacaoDAOMySQL.consultarAvaliacao( this.codigo ).getCodigo() == 0 ) {
			avaliacaoDAOMySQL.inserirAvaliacao( this );
			System.out.println( "Avaliacao inserida com sucesso no sistema" );
		}
		else {
			avaliacaoDAOMySQL.atualizarAvaliacao( this );
			System.out.println( "Avaliacao atualizada com sucesso no sistema" );
		}
		
		avaliacaoDAOMySQL.fechar();
	}
}