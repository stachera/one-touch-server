package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Compra;
import com.up.onetouch.bean.CompraStatus;
import com.up.onetouch.bo.CompraBO;
import com.up.onetouch.bo.CompraStatusBO;

@ManagedBean
@ViewScoped
public class CompraStatusMB extends DefaultBean<CompraStatus> {

	private static final long serialVersionUID = 1L;

	public CompraStatusMB() {
		super(new CompraStatusBO());
		setClazz(CompraStatus.class);		
	}
}