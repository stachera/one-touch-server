package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Compra;
import com.up.onetouch.bo.CompraBO;

@ManagedBean
@ViewScoped
public class CompraMB extends DefaultBean<Compra> {

	private static final long serialVersionUID = 1L;

	public CompraMB() {
		super(new CompraBO());
		setClazz(Compra.class);		
	}
}