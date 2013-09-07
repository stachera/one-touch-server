package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@Table(name="compra")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer compraId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date compraData;

	@Column(nullable=false)
	private Integer statusId;

	@Column(nullable=false)
	private Integer usuarioId;

	//bi-directional many-to-one association to ItemCompra
	@OneToMany(mappedBy="compra")
	private Set<ItemCompra> items;

	public Compra() {
	}

	public int getCompraId() {
		return this.compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public Date getCompraData() {
		return this.compraData;
	}

	public void setCompraData(Date compraData) {
		this.compraData = compraData;
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Set<ItemCompra> getItems() {
		return this.items;
	}

	public void setItems(Set<ItemCompra> items) {
		this.items = items;
	}

	public ItemCompra addItem(ItemCompra item) {
		getItems().add(item);
		item.setCompra(this);

		return item;
	}

	public ItemCompra removeItem(ItemCompra item) {
		getItems().remove(item);
		item.setCompra(null);

		return item;
	}

}