package br.com.fiap.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.bo.CarrinhoCompraBO;

@Stateful
public class CarrinhoCompraBOImpl implements CarrinhoCompraBO {

	private List<String> itens = new ArrayList<String>();
	
	@Override
	public void adicionarItem(String item) {
		itens.add(item);
	}

	@Override
	public List<String> checkout() {
		return itens;
	}

}
