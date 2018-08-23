package br.com.fiap.view;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.bo.ClienteBO;

public class ConsoleView {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		try {
			Context context = new InitialContext(prop);
			
			ClienteBO bo = (ClienteBO) context.lookup("ejb:/09-EJB/ClienteBOImpl"
					+ "!br.com.fiap.bo.ClienteBO");
			
			System.out.println(bo.calcularImpostoRenda(500));
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
}
