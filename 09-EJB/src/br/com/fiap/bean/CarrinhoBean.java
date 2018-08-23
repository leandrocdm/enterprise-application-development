package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.bo.CarrinhoCompraBO;

@ManagedBean
@SessionScoped
public class CarrinhoBean {

	@EJB
	private CarrinhoCompraBO bo;
	
	private String item;
	private List<String> lista;
	
	@PostConstruct
	private void init() {
		lista = bo.checkout();
	}
	
	public void adicionar() {
		bo.adicionarItem(item);
		lista = bo.checkout();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	
}
