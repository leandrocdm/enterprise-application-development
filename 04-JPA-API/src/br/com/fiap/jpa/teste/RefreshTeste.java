package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Carro;

public class RefreshTeste {

	public static void main(String[] args) {
		//Criar o EntityManager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar um veículo no banco
		Carro carro = em.find(Carro.class, 1);
		
		//Exibir o modelo do carro
		System.out.println(carro.getModelo());
		
		//Alterar o valor do modelo no java
		carro.setModelo("Astra");
		
		//Exibir o modelo do carro
		System.out.println(carro.getModelo());
		
		//Refresh
		em.refresh(carro);
		
		//Exibir o modelo do carro
		System.out.println(carro.getModelo());
		
		em.close();
		fabrica.close();
	}
	
}