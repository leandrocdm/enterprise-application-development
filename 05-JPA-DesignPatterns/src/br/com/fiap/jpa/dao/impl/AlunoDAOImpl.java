package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.AlunoDAO;
import br.com.fiap.jpa.entity.Aluno;

public class AlunoDAOImpl 
				extends GenericDAOImpl<Aluno, String>
							implements AlunoDAO{

	public AlunoDAOImpl(EntityManager em) {
		super(em);
	}

}