package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.entity.Pessoa;

public class PessoaDAOImpl 
				extends GenericDAOImpl<Pessoa, Integer>
										implements PessoaDAO{

	public PessoaDAOImpl(EntityManager em) {
		super(em);
	}

}
