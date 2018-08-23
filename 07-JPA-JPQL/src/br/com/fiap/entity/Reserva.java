package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name="Reserva.contarPorDatas",
		query="select count(r) from Reserva r where "
			+ "r.dataReserva between :inicio and :fim"),
	@NamedQuery(name="Reserva.contarPorEstadoCliente",
		query="select count(r) from Reserva r where "
			+ "r.cliente.endereco.cidade.uf = :churros")		
})

@Entity
@Table(name="JPA_T_RESERVA")
@SequenceGenerator(name="seqReserva", sequenceName="SEQ_JPA_T_RESERVA", allocationSize=1)
public class Reserva {

	@Id
	@Column(name="cd_reserva")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqReserva")
	private int id;
	
	@Column(name="nr_dias")
	private int numeroDias;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_reserva")
	private Calendar dataReserva;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Pacote pacote;
	
	@ManyToOne
	private Cliente cliente;
	
	public Reserva(int numeroDias, Calendar dataReserva, Pacote pacote, Cliente cliente) {
		super();
		this.numeroDias = numeroDias;
		this.dataReserva = dataReserva;
		this.pacote = pacote;
		this.cliente = cliente;
	}

	public Reserva() {
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Calendar getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}

	public int getId() {
		return id;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
