package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.LivroDAO;
import br.com.fiap.jpa.entity.Livro;

public class LivroDAOImpl 
			extends GenericDAOImpl<Livro, Integer>
									implements LivroDAO {

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

}