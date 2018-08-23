package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.AlunoDAO;
import br.com.fiap.jpa.dao.impl.AlunoDAOImpl;
import br.com.fiap.jpa.entity.Aluno;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Cadastrar
		Aluno aluno = new Aluno("rm22222", "Oscar");
		AlunoDAO dao = new AlunoDAOImpl(em);
		
		try {
			dao.inserir(aluno);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Buscar
		Aluno busca = dao.pesquisar(aluno.getRm());
		System.out.println(busca.getNome());
		
		//Atualizar
		busca.setNome("Alexandre");
		try {
			dao.atualizar(busca);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Remover
		try {
			dao.remover(busca.getRm());
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
	
}
