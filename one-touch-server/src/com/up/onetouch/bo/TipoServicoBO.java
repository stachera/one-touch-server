package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.TipoServico;
import com.up.onetouch.dao.GenericDAO;

public class TipoServicoBO extends BO<TipoServico>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(TipoServicoBO.class);

	public TipoServicoBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(TipoServico.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}