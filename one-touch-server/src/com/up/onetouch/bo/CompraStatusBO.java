package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.CompraStatus;
import com.up.onetouch.dao.GenericDAO;

public class CompraStatusBO extends BO<CompraStatus>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(CompraStatusBO.class);

	public CompraStatusBO() {
		setClazz(CompraStatus.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}