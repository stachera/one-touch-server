package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comprastatus database table.
 * 
 */
@Entity
@Table(name="comprastatus")
public class CompraStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer statusId;

	@Column(nullable=false, length=45)
	private String statusNome;

	public CompraStatus() {
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusNome() {
		return this.statusNome;
	}

	public void setStatusNome(String statusNome) {
		this.statusNome = statusNome;
	}

}