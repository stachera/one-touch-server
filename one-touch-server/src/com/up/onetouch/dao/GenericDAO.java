package com.up.onetouch.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

public class GenericDAO<E> extends GenericListDAO<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String PERSISTUNIT = "one-touch";
	
	private transient Logger log = Logger.getLogger(GenericDAO.class);
	
	public GenericDAO(String persistenceUnitName) {
	    super(persistenceUnitName);
	}

	public boolean persist(E entity) throws Exception {
		boolean persist = false;
		if (entity != null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.persist(entity);
				entityManager.getTransaction().commit();
				persist = true;
			}
			catch (Exception e) {
				if (entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
				log.error("Erro no persist", e);
				throw e;
			}
		}
		return persist;
	}

	public boolean merge(E entity) throws Exception {
		boolean merge = false;
		if (entity != null) {
			try {
				entityManager.getTransaction().begin();
				entityManager.merge(entity);
				entityManager.getTransaction().commit();
				merge = true;
			}
			catch (Exception e) {
				if (entityManager.getTransaction().isActive()) {
					entityManager.getTransaction().rollback();
				}
				log.error("Erro no merge", e);				
				throw e;
			}
		}
		return merge;
	}

	public boolean remove(E entity) throws Exception {
		boolean remove = false;
		try {
			if (entity != null) {
				entityManager.getTransaction().begin();
				entity = entityManager.merge(entity);
				entityManager.remove(entity);
				entityManager.getTransaction().commit();
				remove = true;
			}
		}
		catch (Exception e) {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			log.error("Erro no remove", e);			
			throw e;
		}
		return remove;
	}

	public boolean refresh(E entity) throws Exception {
		boolean refresh = false;
		if (entity != null) {
			entityManager.refresh(entity);
			refresh = true;
		}
		return refresh;
	}

	public Query createQuery(String jpql) throws Exception {
		Query query = null;
		if (jpql != null && !jpql.isEmpty()) {
			query = entityManager.createQuery(jpql);
		}
		return query;
	}

	public Query createNamedQuery(String nameQuery) throws Exception {
		Query query = null;
		if (nameQuery != null && !nameQuery.isEmpty()) {
			query = entityManager.createNamedQuery(nameQuery);
		}
		return query;
	}

	public void executeQuery(Query query) throws Exception {
		if (query != null) {
			entityManager.getTransaction().begin();
			query.executeUpdate();
			entityManager.flush();
			entityManager.getTransaction().commit();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public Query createNativeQuery(String sql, Class clazz) throws Exception {
		Query query = null;
		if (sql != null && !sql.isEmpty()) {
			query = entityManager.createNativeQuery(sql, clazz);
		}
		return query;
	}
	
	public Query createNativeQuery(String sql) throws Exception {
        Query query = null;
        if (sql != null && !sql.isEmpty()) {
            query = entityManager.createNativeQuery(sql);
        }
        return query;
    }
	
	public void persistBatch(List<E> entities) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        int i = 0;
        for ( E entity : entities ) {
            try {
                entityManager.persist(entity);
            }catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw new Exception(e);
            }
            if ( i++ % 20 == 0 ) { 
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
        tx.commit();        
    }
    
	public TypedQuery<?> createTypedQuery(String jpql, Class<?> type) {
        TypedQuery<?> query = null;
        if (jpql != null && !jpql.isEmpty()) {
            query = entityManager.createQuery(jpql, type);
        }
        return query;
    }
	
    public void mergeBatch(List<E> entities) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        int i = 0;
        for ( E entity : entities ) {
            try {
                entityManager.merge(entity);
            }catch (Exception e) {
                if (tx.isActive()) {
                    tx.rollback();
                }
                throw new Exception(e);
            }
            if ( i++ % 20 == 0 ) { 
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
        tx.commit();        
    }
    
    public java.sql.Connection getJDBCConnection(){
    	java.sql.Connection conn = null;
    	Session session = entityManager.unwrap(Session.class);    	
    	SessionFactoryImpl  sfi = (SessionFactoryImpl) session.getSessionFactory();
    	    	
    	try {
			conn = sfi.getConnectionProvider().getConnection();
		} catch (SQLException e) {		
			log.error(e);
		}
    	
    	return conn;
    }
}
