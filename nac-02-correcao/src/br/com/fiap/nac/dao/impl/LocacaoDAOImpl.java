package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.LocacaoDAO;
import br.com.fiap.nac.entity.Locacao;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Integer>
	implements LocacaoDAO{

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
