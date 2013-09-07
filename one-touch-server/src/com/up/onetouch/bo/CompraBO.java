package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Compra;
import com.up.onetouch.dao.GenericDAO;

public class CompraBO extends BO<Compra>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(CompraBO.class);

	public CompraBO() {
		setClazz(Compra.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}