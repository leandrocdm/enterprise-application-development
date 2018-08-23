package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.MotoristaDAO;
import br.com.fiap.jpa.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.entity.Genero;
import br.com.fiap.jpa.entity.Motorista;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class MotoristaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		//Cadastrar
		Motorista motorista = new Motorista(123, "Thiago", new GregorianCalendar(1999, Calendar.JANUARY, 2), null, Genero.MASCULINO);
		try {
			dao.cadastrar(motorista);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		//Buscar
		Motorista busca = dao.buscar(123);
		//Atualizar
		try {
			busca.setNome("Joao");
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Remover
		try {
			dao.remover(123);
			dao.commit();
			System.out.println("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}
	
}
