package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Compra;
import com.up.onetouch.bean.ItemCompra;
import com.up.onetouch.bo.CompraBO;
import com.up.onetouch.bo.ItemCompraBO;

@ManagedBean
@ViewScoped
public class ItemCompraMB extends DefaultBean<ItemCompra> {

	private static final long serialVersionUID = 1L;

	public ItemCompraMB() {
		super(new ItemCompraBO());
		setClazz(ItemCompra.class);		
	}
}