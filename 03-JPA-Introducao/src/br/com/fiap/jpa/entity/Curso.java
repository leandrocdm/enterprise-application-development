package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CURSO")
@SequenceGenerator(name="curso",sequenceName="SQ_T_CURSO",allocationSize=1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(generator="curso",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_curso",nullable=false,length=100)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="st_curso")
	private StatusCurso status;
	
	@Column(name="nr_semestre",nullable=false)
	private int semestres;
	
	@Column(name="dt_criacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataCriacao;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	public Curso(String nome, StatusCurso status, int semestres, Calendar dataCriacao, byte[] logo) {
		super();
		this.nome = nome;
		this.status = status;
		this.semestres = semestres;
		this.dataCriacao = dataCriacao;
		this.logo = logo;
	}

	public Curso() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusCurso getStatus() {
		return status;
	}

	public void setStatus(StatusCurso status) {
		this.status = status;
	}

	public int getSemestres() {
		return semestres;
	}

	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
}
