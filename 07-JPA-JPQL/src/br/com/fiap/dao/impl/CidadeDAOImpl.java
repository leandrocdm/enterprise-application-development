package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery(
			"from Cidade",Cidade.class);
		//Executar a query		
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorNome(String nome) {
		//Criar a query
		TypedQuery<Cidade> query = em.createQuery(
			"from Cidade c where upper(c.nome) like upper(:nomeCidade)",Cidade.class);
		//Passar o parametro para a query
		query.setParameter("nomeCidade", "%"+nome+"%");
		//Executar a query
		return query.getResultList();
	}

}





