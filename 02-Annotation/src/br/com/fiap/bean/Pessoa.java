package br.com.fiap.bean;

import br.com.fiap.annotation.Coluna;
import br.com.fiap.annotation.Tabela;

@Tabela(nome="t_pessoa")
public class Pessoa {

	@Coluna(nome="nm_pessoa")
	private String nome;
	
	@Coluna(nome="nr_idade")
	private int idade;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
