package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	//1 - Atributo estático
	private static EntityManagerFactory fabrica;
	
	//2 - Construtor privado
	private EntityManagerFactorySingleton(){}
	
	//3 - Método estático
	public static EntityManagerFactory  getInstance(){
		if (fabrica == null){
			fabrica = Persistence
					.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
}






