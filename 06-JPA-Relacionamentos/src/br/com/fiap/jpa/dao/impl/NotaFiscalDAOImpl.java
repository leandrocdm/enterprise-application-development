package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.entity.NotaFiscal;

public class NotaFiscalDAOImpl 
			extends GenericDAOImpl<NotaFiscal,Integer>
								implements NotaFiscalDAO{

	public NotaFiscalDAOImpl(EntityManager em) {
		super(em);
	}

}
