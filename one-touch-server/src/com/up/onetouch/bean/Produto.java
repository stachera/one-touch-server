package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int produtoId;

	@Column(nullable=false)
	private int categoriaId;

	@Column(nullable=false)
	private int lojaId;

	@Lob
	private byte[] produtoImagem;

	@Column(nullable=false, length=45)
	private String produtoNome;

	private Float produtoPreco;

	//bi-directional many-to-one association to ItemCompra
	@OneToMany(mappedBy="produto")
	private Set<ItemCompra> items;

	public Produto() {
	}

	public Integer getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Integer getLojaId() {
		return this.lojaId;
	}

	public void setLojaId(Integer lojaId) {
		this.lojaId = lojaId;
	}

	public byte[] getProdutoImagem() {
		return this.produtoImagem;
	}

	public void setProdutoImagem(byte[] produtoImagem) {
		this.produtoImagem = produtoImagem;
	}

	public String getProdutoNome() {
		return this.produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	public Float getProdutoPreco() {
		return this.produtoPreco;
	}

	public void setProdutoPreco(Float produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	public Set<ItemCompra> getItems() {
		return this.items;
	}

	public void setItems(Set<ItemCompra> items) {
		this.items = items;
	}

	public ItemCompra addItem(ItemCompra item) {
		getItems().add(item);
		item.setProduto(this);

		return item;
	}

	public ItemCompra removeItem(ItemCompra item) {
		getItems().remove(item);
		item.setProduto(null);

		return item;
	}

}