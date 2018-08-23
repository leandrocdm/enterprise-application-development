package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Carro;
import br.com.fiap.jpa.exception.CarNotFoundException;
import br.com.fiap.jpa.exception.CommitException;

public interface CarroDAO {

	void create(Carro carro);
	void update(Carro carro);
	void delete(int codigo) throws CarNotFoundException;
	Carro find(int codigo);
	
	void commit() throws CommitException;
	
}