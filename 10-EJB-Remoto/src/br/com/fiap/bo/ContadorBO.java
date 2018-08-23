package br.com.fiap.bo;

import javax.ejb.Local;

@Local
public interface ContadorBO {

	void incrementar();
	
	int verTotal();
	
}
