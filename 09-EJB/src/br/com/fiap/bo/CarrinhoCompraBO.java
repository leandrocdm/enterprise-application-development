package br.com.fiap.bo;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface CarrinhoCompraBO {

	void adicionarItem(String item);
	
	List<String> checkout();
	
}
