package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_ALUNO")
public class Aluno {

	@Id
	private String rm;
	
	@Column(name="nm_aluno",nullable=false)
	private String nome;
	
	public Aluno() {
		super();
	}

	public Aluno(String rm, String nome) {
		super();
		this.rm = rm;
		this.nome = nome;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}