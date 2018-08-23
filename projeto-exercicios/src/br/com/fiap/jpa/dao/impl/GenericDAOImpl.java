package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontrado;

public class GenericDAOImpl<Tabela,Chave> 
					implements GenericDAO<Tabela, Chave>{

	private EntityManager em;
	
	private Class<Tabela> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<Tabela>) ((ParameterizedType)
					getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(Tabela tabela) {
		em.persist(tabela);
	}

	@Override
	public void atualizar(Tabela tabela) {
		em.merge(tabela);
	}

	@Override
	public void remover(Chave codigo) throws RegistroNaoEncontrado {
		Tabela tabela = buscar(codigo);
		if (tabela == null){
			throw new RegistroNaoEncontrado("Registro não encontrado");
		}
		em.remove(tabela);
	}

	@Override
	public Tabela buscar(Chave codigo) {
		return em.find(classe, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try{
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
		
	}

}
