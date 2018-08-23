package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CARRO")
@SequenceGenerator(name="carro",sequenceName="SQ_TB_CARRO",allocationSize=1)
public class Carro implements Serializable {

	@Id
	@Column(name="cd_carro")
	@GeneratedValue(generator="carro",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_modelo",nullable=false,length=50)
	private String modelo;
	
	@Column(name="nr_ano",nullable=false)
	private int ano;
	
	@Column(name="ds_placa",length=7)
	private String placa;
	
	@Column(name="ds_tipo")
	private TipoCarro tipo;
	
	@Column(name="dt_fabricacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataFabricacao;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;

	public Carro() {
		super();
	}

	public Carro(String modelo, int ano, String placa, TipoCarro tipo, Calendar dataFabricacao, byte[] foto) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.tipo = tipo;
		this.dataFabricacao = dataFabricacao;
		this.foto = foto;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}
