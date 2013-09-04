package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.ItemCompra;
import com.up.onetouch.dao.GenericDAO;

public class ItemCompraBO extends BO<ItemCompra>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(ItemCompraBO.class);

	public ItemCompraBO() {
		setClazz(ItemCompra.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}