package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida",sequenceName="SQ_T_CORRIDA",allocationSize=1)
public class Corrida {

	@Id
	@Column(name="cd_corrida")
	@GeneratedValue(generator="corrida",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_origem",length=150)
	private String origem;
	
	@Column(name="ds_destino",length=150)
	private String destino;
	
	@Column(name="dt_corrida")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	@Column(name="vl_corrida",nullable=false)
	private double valor;

	public Corrida() {
		super();
	}

	public Corrida(String origem, String destino, Calendar data, double valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
