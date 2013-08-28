package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the servico database table.
 * 
 */
@Entity
@Table(name="servico")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int servicoId;

	private byte servicoConcluido;

	@Temporal(TemporalType.TIMESTAMP)
	private Date servicoDataFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date servicoDataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date servicoDataPgto;

	private byte servicoPago;

	private float servicoValor;

	//bi-directional many-to-one association to ItemCompra
	@OneToMany(mappedBy="servico")
	private Set<ItemCompra> items;

	//bi-directional many-to-one association to TipoServico
	@ManyToOne
	@JoinColumn(name="tipoServicoId", nullable=false)
	private TipoServico tiposervico;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuarioId", nullable=false)
	private Usuario usuario;

	public Servico() {
	}

	public int getServicoId() {
		return this.servicoId;
	}

	public void setServicoId(int servicoId) {
		this.servicoId = servicoId;
	}

	public byte getServicoConcluido() {
		return this.servicoConcluido;
	}

	public void setServicoConcluido(byte servicoConcluido) {
		this.servicoConcluido = servicoConcluido;
	}

	public Date getServicoDataFim() {
		return this.servicoDataFim;
	}

	public void setServicoDataFim(Date servicoDataFim) {
		this.servicoDataFim = servicoDataFim;
	}

	public Date getServicoDataInicio() {
		return this.servicoDataInicio;
	}

	public void setServicoDataInicio(Date servicoDataInicio) {
		this.servicoDataInicio = servicoDataInicio;
	}

	public Date getServicoDataPgto() {
		return this.servicoDataPgto;
	}

	public void setServicoDataPgto(Date servicoDataPgto) {
		this.servicoDataPgto = servicoDataPgto;
	}

	public byte getServicoPago() {
		return this.servicoPago;
	}

	public void setServicoPago(byte servicoPago) {
		this.servicoPago = servicoPago;
	}

	public float getServicoValor() {
		return this.servicoValor;
	}

	public void setServicoValor(float servicoValor) {
		this.servicoValor = servicoValor;
	}

	public Set<ItemCompra> getItems() {
		return this.items;
	}

	public void setItems(Set<ItemCompra> items) {
		this.items = items;
	}

	public ItemCompra addItem(ItemCompra item) {
		getItems().add(item);
		item.setServico(this);

		return item;
	}

	public ItemCompra removeItem(ItemCompra item) {
		getItems().remove(item);
		item.setServico(null);

		return item;
	}

	public TipoServico getTiposervico() {
		return this.tiposervico;
	}

	public void setTiposervico(TipoServico tiposervico) {
		this.tiposervico = tiposervico;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}