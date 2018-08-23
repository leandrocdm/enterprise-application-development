package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.entity.Curso;
import br.com.fiap.jpa.entity.Periodo;
import br.com.fiap.jpa.entity.StatusCurso;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");	
		EntityManager em = fabrica.createEntityManager();
		
		Aluno aluno = new Aluno("Pedrinho", "ADS", 
				new GregorianCalendar(2000, Calendar.OCTOBER, 2) ,
				true, Periodo.NOTURNO, 3, null, null);
		
		Curso curso = new Curso("ADS", 
				StatusCurso.ATIVO, 4, 
				new GregorianCalendar(1994, Calendar.JANUARY, 1), null);
		
		em.getTransaction().begin(); //inicia a transação
		em.persist(aluno);
		em.persist(curso);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}
