package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tiposervico database table.
 * 
 */
@Entity
@Table(name="tiposervico")
public class TipoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int tipoServicoId;

	@Column(nullable=false, length=45)
	private String tipoServicoNome;

	@Column(nullable=false)
	private float tipoServicoValor;

	//bi-directional many-to-one association to Servico
	@OneToMany(mappedBy="tiposervico")
	private Set<Servico> servicos;

	public TipoServico() {
	}

	public int getTipoServicoId() {
		return this.tipoServicoId;
	}

	public void setTipoServicoId(int tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}

	public String getTipoServicoNome() {
		return this.tipoServicoNome;
	}

	public void setTipoServicoNome(String tipoServicoNome) {
		this.tipoServicoNome = tipoServicoNome;
	}

	public float getTipoServicoValor() {
		return this.tipoServicoValor;
	}

	public void setTipoServicoValor(float tipoServicoValor) {
		this.tipoServicoValor = tipoServicoValor;
	}

	public Set<Servico> getServicos() {
		return this.servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public Servico addServico(Servico servico) {
		getServicos().add(servico);
		servico.setTiposervico(this);

		return servico;
	}

	public Servico removeServico(Servico servico) {
		getServicos().remove(servico);
		servico.setTiposervico(null);

		return servico;
	}

}