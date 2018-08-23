package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.dao.impl.VeiculoDAOImpl;
import br.com.fiap.jpa.entity.Veiculo;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class VeiculoTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		VeiculoDAO dao = new VeiculoDAOImpl(em);
		
		//Cadastrar
		Veiculo veiculo = new Veiculo("DAS8985", "Branco", 2010);
		try {
			dao.cadastrar(veiculo);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		//Buscar
		Veiculo busca = dao.buscar(veiculo.getCodigo());
		//Atualizar
		try {
			busca.setCor("Azul");
			dao.atualizar(busca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Remover
		try {
			dao.remover(busca.getCodigo());
			dao.commit();
			System.out.println("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}
	
}
