package br.com.fiap.nac.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="NAC_LOCACAO")
@SequenceGenerator(name="locacao", sequenceName="SEQ_NAC_LOCACAO", allocationSize=1)
public class Locacao {

	@Id
	@GeneratedValue(generator="locacao", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio", nullable=false)	
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_fim", nullable=false)
	private Calendar dataFim;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cliente_codigo")
	private Cliente cliente;
	 
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="apartamento_codigo")
	private Apartamento apartamento;
	
	
	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Locacao() {}
	
	public Locacao(Calendar dataInicio, Calendar dataFim) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	
}
