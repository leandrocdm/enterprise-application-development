package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		PedidoDAO dao = new PedidoDAOImpl(em);
		//Pesquisa o pedido

		Pedido pedido = dao.pesquisar(1);
		System.out.println(pedido.getDescricao());
		System.out.println(pedido.getNota().getValor());

		


		em.close();
		fabrica.close();
	}

}
