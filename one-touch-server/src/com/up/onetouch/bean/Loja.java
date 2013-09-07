package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loja database table.
 * 
 */
@Entity
@Table(name="loja")
public class Loja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer lojaId;

	@Column(nullable=false, length=50)
	private String lojaEmail;

	@Column(nullable=false, length=50)
	private String lojaLocalizacao;

	@Column(nullable=false, length=100)
	private String lojaNome;

	private byte lojaProvadorVirtual;

	@Column(nullable=false, length=20)
	private String lojaTelefone;

	@Column(nullable=false, length=100)
	private String lojaWebsite;

	//bi-directional many-to-one association to LojaCategoria
	@ManyToOne
	@JoinColumn(name="categoriaId", nullable=false)
	private LojaCategoria lojacategoria;

	public Loja() {
	}

	public Integer getLojaId() {
		return this.lojaId;
	}

	public void setLojaId(Integer lojaId) {
		this.lojaId = lojaId;
	}

	public String getLojaEmail() {
		return this.lojaEmail;
	}

	public void setLojaEmail(String lojaEmail) {
		this.lojaEmail = lojaEmail;
	}

	public String getLojaLocalizacao() {
		return this.lojaLocalizacao;
	}

	public void setLojaLocalizacao(String lojaLocalizacao) {
		this.lojaLocalizacao = lojaLocalizacao;
	}

	public String getLojaNome() {
		return this.lojaNome;
	}

	public void setLojaNome(String lojaNome) {
		this.lojaNome = lojaNome;
	}

	public byte getLojaProvadorVirtual() {
		return this.lojaProvadorVirtual;
	}

	public void setLojaProvadorVirtual(byte lojaProvadorVirtual) {
		this.lojaProvadorVirtual = lojaProvadorVirtual;
	}

	public String getLojaTelefone() {
		return this.lojaTelefone;
	}

	public void setLojaTelefone(String lojaTelefone) {
		this.lojaTelefone = lojaTelefone;
	}

	public String getLojaWebsite() {
		return this.lojaWebsite;
	}

	public void setLojaWebsite(String lojaWebsite) {
		this.lojaWebsite = lojaWebsite;
	}

	public LojaCategoria getLojacategoria() {
		return this.lojacategoria;
	}

	public void setLojacategoria(LojaCategoria lojacategoria) {
		this.lojacategoria = lojacategoria;
	}

}