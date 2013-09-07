package com.up.onetouch.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the visita database table.
 * 
 */
@Entity
@Table(name="visita")
public class Visita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer visitaId;

	@Column(nullable=false)
	private Integer usuarioId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date visitaDataFim;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date visitaDataInicio;

	public Visita() {
	}

	public Integer getVisitaId() {
		return this.visitaId;
	}

	public void setVisitaId(Integer visitaId) {
		this.visitaId = visitaId;
	}

	public Integer getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Date getVisitaDataFim() {
		return this.visitaDataFim;
	}

	public void setVisitaDataFim(Date visitaDataFim) {
		this.visitaDataFim = visitaDataFim;
	}

	public Date getVisitaDataInicio() {
		return this.visitaDataInicio;
	}

	public void setVisitaDataInicio(Date visitaDataInicio) {
		this.visitaDataInicio = visitaDataInicio;
	}

}