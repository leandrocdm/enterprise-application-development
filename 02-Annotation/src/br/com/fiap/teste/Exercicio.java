package br.com.fiap.teste;

import br.com.fiap.annotation.Tabela;
import br.com.fiap.bean.Pessoa;

public class Exercicio {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		//Recuperar a anotação
		Tabela anotacao = pessoa.getClass()
				.getAnnotation(Tabela.class);
		
		System.out.println("select * from "
				+ anotacao.nome());
	}
	
}
