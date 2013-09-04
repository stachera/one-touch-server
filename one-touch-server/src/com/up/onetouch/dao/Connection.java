package com.up.onetouch.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

public class Connection implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private static Connection instance;  
    
	private transient Logger log = Logger.getLogger(Connection.class);
	
	private EntityManager em;
	
	private Connection() {
		String persistUnit = "one-touch";
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistUnit); 
		em = emf.createEntityManager();
	}
	
	public static Connection getInstance() {		
		if (instance == null) {
			instance = new Connection();
		}		
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
}
