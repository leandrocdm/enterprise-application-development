package br.com.fiap.nac.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.dao.impl.LocacaoDAOImpl;
import br.com.fiap.nac.entity.Apartamento;
import br.com.fiap.nac.entity.Cliente;
import br.com.fiap.nac.entity.Locacao;
import br.com.fiap.nac.entity.Sexo;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class TesteCadastro {

	public static void main(String[] args) {
		
		EntityManagerFactory fab = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fab.createEntityManager();
		
		Apartamento ap = new Apartamento("Rua Manuel Leitao", "Apt de luxo, cobertura", null);
		Cliente cliente = new Cliente("Leandro", Calendar.getInstance(), Sexo.MASCULINO);
		Locacao loc = new Locacao(Calendar.getInstance(), Calendar.getInstance());
		
		loc.setApartamento(ap);
		loc.setCliente(cliente);
		
		LocacaoDAO dao = new LocacaoDAOImpl(em);
		
		try {
			dao.cadastrar(loc);
			dao.salvar();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fab.close();
	}
	
}
