package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Compra;
import com.up.onetouch.bean.ProdutoCategoria;
import com.up.onetouch.bo.CompraBO;
import com.up.onetouch.bo.ProdutoCategoriaBO;

@ManagedBean
@ViewScoped
public class ProdutoCategoriaMB extends DefaultBean<ProdutoCategoria> {

	private static final long serialVersionUID = 1L;

	public ProdutoCategoriaMB() {
		super(new ProdutoCategoriaBO());
		setClazz(ProdutoCategoria.class);		
	}
}