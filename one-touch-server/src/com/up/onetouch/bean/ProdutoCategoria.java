package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produtocategoria database table.
 * 
 */
@Entity
@Table(name="produtocategoria")
public class ProdutoCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int categoriaId;

	@Column(nullable=false, length=45)
	private String categoriaNome;

	public ProdutoCategoria() {
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

}