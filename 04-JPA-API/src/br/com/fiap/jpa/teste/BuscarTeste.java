package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Carro;

public class BuscarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
							
							//Tabela, chave primária
		Carro carro = em.find(Carro.class,1);
		
		System.out.println(carro.getModelo());
		
		em.close();
		fabrica.close();
	}
	
}
