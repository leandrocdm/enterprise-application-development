package br.com.fiap.nac.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="NAC_APARTAMENTO")
@Entity
@SequenceGenerator(name="apartamento", sequenceName="SEQ_NAC_APTO", allocationSize=1)
public class Apartamento {

	@Id
	@GeneratedValue(generator="apartamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_endereco", nullable=false, length=150)
	private String endereco;
	
	@Column(length=300)
	private String detalhes;
	
	@Lob
	private byte[] foto;
	
	
	@OneToMany(mappedBy="cliente")
	private List<Locacao> locacao;
	

	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	public Apartamento() {}
	
	public Apartamento(String endereco, String detalhes, byte[] foto) {
		this.endereco = endereco;
		this.detalhes = detalhes;
		this.foto = foto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}
