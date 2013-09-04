package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.LojaCategoria;
import com.up.onetouch.dao.GenericDAO;

public class LojaCategoriaBO extends BO<LojaCategoria>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(LojaCategoriaBO.class);

	public LojaCategoriaBO() {
		setClazz(LojaCategoria.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}