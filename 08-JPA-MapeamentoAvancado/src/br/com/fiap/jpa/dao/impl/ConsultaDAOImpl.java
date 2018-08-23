package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.ConsultaPK;

public class ConsultaDAOImpl 
				extends GenericDAOImpl<Consulta, ConsultaPK>
											implements ConsultaDAO{

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
	}

}