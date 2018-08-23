package br.com.fiap.bean;

import java.io.Serializable;

public class ContaPoupanca implements ContaInvestimento, Serializable{

	@Override
	public double calculaRetornoInvestimento() {
		return 0;
	}

}