package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.entity.TipoCarro;

public class AtualizarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Carro carro = new Carro("Gol", 2015, "DDD9090", 
			TipoCarro.PASSEIO, Calendar.getInstance(), null);
		
		carro.setCodigo(1);
		
		em.getTransaction().begin();
		em.merge(carro);//Atualizar
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}


