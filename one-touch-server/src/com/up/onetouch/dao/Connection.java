package com.up.onetouch.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class Connection implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private static Connection instance;  
    
    private Map<String,EntityManager> em = new HashMap<String,EntityManager>();
    
    private List<String> persistUnits;
    
	private transient Logger log = Logger.getLogger(Connection.class);
	
	private Connection() {}
	
	public static Connection getInstance() {		
		if (instance == null) {
			instance = new Connection();
		}		
		return instance;
	}
	
	public List<String> getPersistUnits() {
		return persistUnits;
	}

	public void setPersistUnits(List<String> persistUnits) {
		this.persistUnits = persistUnits;
	}

	public EntityManager getEntityManager(String persistUnit) {		
		return getEm().get("EntityManager" + persistUnit);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	public Map<String,EntityManager> getEm() {
		return em;
	}
	
	public void createEntityManager(HttpServletRequest request){
		for(String persistUnit : Connection.getInstance().getPersistUnits()){
    		if(!Connection.getInstance().getEm().containsKey("EntityManager" + persistUnit)){
        		EntityManagerFactory factory = (EntityManagerFactory) request.getServletContext().getAttribute("factory" + persistUnit);
        		EntityManager em = factory.createEntityManager();
        		Connection.getInstance().getEm().put("EntityManager" + persistUnit,em);
        		request.setAttribute("EntityManager" + persistUnit, em);
    		}
		}
	}
	
	public void dropEntityManager(){
		for(String persistUnit : Connection.getInstance().getPersistUnits()){
			if(Connection.getInstance().getEm().containsKey("EntityManager" + persistUnit))
				Connection.getInstance().getEm().get("EntityManager" + persistUnit).close();		
		}
		Connection.getInstance().getEm().clear();
	}
}
