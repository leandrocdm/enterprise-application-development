package br.com.fiap.bo.impl;

import javax.ejb.Singleton;
import br.com.fiap.bo.ContadorBO;

@Singleton
public class ContadorBOImpl implements ContadorBO {

	private int total;
	
	@Override
	public void incrementar() {
		total++;
	}

	@Override
	public int verTotal() {
		return total;
	}
	
}
