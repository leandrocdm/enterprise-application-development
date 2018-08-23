package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar uma Pessoa, PF e PJ
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		Pessoa pessoa = new Pessoa("Willian","Jardins");
		PessoaFisica pf = new PessoaFisica("Peixoto", 
				"Diadema", "232.65.565-98", "32.657.655-88");
		PessoaJuridica pj = new PessoaJuridica("FIAP", 
				"Lins", "232.656.223/0001-8", "FIAP");
		
		try {
			dao.inserir(pessoa);
			dao.inserir(pf);
			dao.inserir(pj);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}