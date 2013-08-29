package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Visita;
import com.up.onetouch.bo.VisitaBO;

@ManagedBean
@ViewScoped
public class VisitaMB extends DefaultBean<Visita> {

	private static final long serialVersionUID = 1L;

	public VisitaMB() {
		super(new VisitaBO());
		setClazz(Visita.class);		
	}
}