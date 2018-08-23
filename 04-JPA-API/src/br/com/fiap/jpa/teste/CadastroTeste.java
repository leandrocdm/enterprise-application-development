package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.TipoCarro;

public class CadastroTeste {

	public static void main(String[] args) {
		Carro carro = new Carro("Corsa", 2015, 
			"AAA1254",TipoCarro.PASSEIO, 
			new GregorianCalendar(2015, Calendar.MARCH, 2), null);
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
	
		em.getTransaction().begin();
		em.persist(carro);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	
	}
	
}




