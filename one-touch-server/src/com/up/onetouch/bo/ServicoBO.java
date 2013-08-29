package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Servico;
import com.up.onetouch.dao.GenericDAO;

public class ServicoBO extends BO<Servico>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(ServicoBO.class);

	public ServicoBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(Servico.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}