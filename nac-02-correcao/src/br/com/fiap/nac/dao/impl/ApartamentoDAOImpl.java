package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.ApartamentoDAO;
import br.com.fiap.nac.entity.Apartamento;

public class ApartamentoDAOImpl extends GenericDAOImpl<Apartamento, Integer>
	implements ApartamentoDAO{

	public ApartamentoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
