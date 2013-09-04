package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Produto;
import com.up.onetouch.dao.GenericDAO;

public class ProdutoBO extends BO<Produto>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(ProdutoBO.class);

	public ProdutoBO() {
		setClazz(Produto.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}