package br.com.fiap.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import br.com.fiap.bo.ContadorBO;

@ManagedBean
public class ContadorBean {

	@EJB
	private ContadorBO bo;
	
	public void contar() { //clique do botão
		bo.incrementar();
	}
	
	public int getTotal() { //campo de texto para exibir o total
		return bo.verTotal();
	}
	
}
