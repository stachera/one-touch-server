/*package com.up.onetouch.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.up.onetouch.dao.Connection;
import com.up.onetouch.dao.GenericDAO;

@WebFilter(servletNames = { "jersey-serlvet", "faces-servlet" } )
public class JPAFilter implements Filter {
	
	private Map<String,EntityManagerFactory> mapFactory = new HashMap<String,EntityManagerFactory>();
	private List<String> listPersistUnit = new ArrayList<String>(Arrays.asList(GenericDAO.PERSISTUNIT));
	
	public JPAFilter(){
	}
	
	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		if(Connection.getInstance().getPersistUnits() == null)
			Connection.getInstance().setPersistUnits(listPersistUnit);
		
		for(String persistUnit : getListPersistUnit()){
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistUnit); 
			getMapFactory().put(persistUnit, emf);
			filterConfig.getServletContext().setAttribute("factory" + persistUnit, emf);
		}
	}
	
	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
		
		try {
			for(String persistUnit : getListPersistUnit()){
				EntityManager em = getMapFactory().get(persistUnit).createEntityManager();
				request.setAttribute("EntityManager" + persistUnit, em);
			}
			
			chain.doFilter(request, response);			
		}
		catch (final Exception ignore) {
		}finally{			
			for(String persistUnit : getListPersistUnit()){
				EntityManager em = (EntityManager) Connection.getInstance().getEntityManager(request, "EntityManager" + persistUnit);				
				if(em != null && em.isOpen()){
					em.close();
				}
			}
		}
	}

	@Override
	public void destroy() {
		for(String persistUnit : getListPersistUnit()){
			getMapFactory().get(persistUnit).close();			
		}
	}

	public Map<String,EntityManagerFactory> getMapFactory() {
		return mapFactory;
	}

	public void setMapFactory(Map<String,EntityManagerFactory> mapFactory) {
		this.mapFactory = mapFactory;
	}

	public List<String> getListPersistUnit() {
		return listPersistUnit;
	}

	public void setListPersistUnit(List<String> listPersistUnit) {
		this.listPersistUnit = listPersistUnit;
	}
}*/