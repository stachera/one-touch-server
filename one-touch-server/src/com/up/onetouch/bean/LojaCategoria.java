package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the lojacategoria database table.
 * 
 */
@Entity
@Table(name="lojacategoria")
public class LojaCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int categoriaId;

	@Column(nullable=false, length=45)
	private String categoriaNome;

	//bi-directional many-to-one association to Loja
	@OneToMany(mappedBy="lojacategoria")
	private Set<Loja> lojas;

	public LojaCategoria() {
	}

	public int getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoriaNome() {
		return this.categoriaNome;
	}

	public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	public Set<Loja> getLojas() {
		return this.lojas;
	}

	public void setLojas(Set<Loja> lojas) {
		this.lojas = lojas;
	}

	public Loja addLoja(Loja loja) {
		getLojas().add(loja);
		loja.setLojacategoria(this);

		return loja;
	}

	public Loja removeLoja(Loja loja) {
		getLojas().remove(loja);
		loja.setLojacategoria(null);

		return loja;
	}

}