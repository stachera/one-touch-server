package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Visita;
import com.up.onetouch.dao.GenericDAO;

public class VisitaBO extends BO<Visita>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(VisitaBO.class);

	public VisitaBO() {
		setClazz(Visita.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	
}