package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontrado;

public interface GenericDAO<Tabela,Chave> {

	void cadastrar(Tabela tabela);
	
	void atualizar(Tabela tabela);
	
	void remover(Chave codigo) throws RegistroNaoEncontrado ;
	
	Tabela buscar(Chave codigo);
	
	void commit() throws CommitException;
}

