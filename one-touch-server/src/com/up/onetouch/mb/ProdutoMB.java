package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Produto;
import com.up.onetouch.bo.ProdutoBO;

@ManagedBean
@ViewScoped
public class ProdutoMB extends DefaultBean<Produto> {

	private static final long serialVersionUID = 1L;

	public ProdutoMB() {
		super(new ProdutoBO());
		setClazz(Produto.class);		
	}
}