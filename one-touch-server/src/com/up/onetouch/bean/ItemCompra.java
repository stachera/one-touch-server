package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the itemcompra database table.
 * 
 */
@Entity
@Table(name="itemcompra")
public class ItemCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int itemId;

	private float itemValor;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="compraId", nullable=false)
	private Compra compra;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="produtoId")
	private Produto produto;

	//bi-directional many-to-one association to Servico
	@ManyToOne
	@JoinColumn(name="servicoId")
	private Servico servico;

	public ItemCompra() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getItemValor() {
		return this.itemValor;
	}

	public void setItemValor(float itemValor) {
		this.itemValor = itemValor;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}