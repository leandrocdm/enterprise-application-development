package br.com.fiap.bo.impl;

import javax.ejb.Stateless;
import br.com.fiap.bo.ClienteBO;

@Stateless
public class ClienteBOImpl implements ClienteBO {

	@Override
	public double calcularImpostoRenda(double rendimento) {
		if (rendimento > 100000)
			return rendimento*0.25;
		else 
			return rendimento*0.10;
	}

}