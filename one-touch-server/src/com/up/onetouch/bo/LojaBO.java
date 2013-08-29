package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Loja;
import com.up.onetouch.dao.GenericDAO;

public class LojaBO extends BO<Loja>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(LojaBO.class);

	public LojaBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(Loja.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}