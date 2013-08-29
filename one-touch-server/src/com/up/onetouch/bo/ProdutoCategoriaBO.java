package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.ProdutoCategoria;
import com.up.onetouch.dao.GenericDAO;

public class ProdutoCategoriaBO extends BO<ProdutoCategoria>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(ProdutoCategoriaBO.class);

	public ProdutoCategoriaBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(ProdutoCategoria.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}