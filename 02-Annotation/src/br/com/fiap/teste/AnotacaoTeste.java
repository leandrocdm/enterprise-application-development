package br.com.fiap.teste;

import java.lang.reflect.Field;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.bean.Pessoa;

public class AnotacaoTeste {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		//API Reflection
		//Recupera o nome da classe
		String classe = pessoa.getClass().getName();
		System.out.println(classe);
		
		//Recupera os atributos da classe
		Field[] attrs =
			pessoa.getClass().getDeclaredFields();
		for (Field field : attrs) {
			System.out.println(field.getName());
			//Recuperar a anotação
			Coluna anotacao =
				field.getAnnotation(Coluna.class);
			if (anotacao != null) {
				System.out.println(anotacao.nome());
			}
		}
	}
	
}




