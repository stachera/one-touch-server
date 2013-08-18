package com.up.onetouch.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.up.onetouch.dao.GenericDAO;


public class BO<E extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient GenericDAO<E> dao;

    private Class<E> clazz;

    private transient Logger log = Logger.getLogger(BO.class);

    private String persistenceUnitName;

    public BO() {
        this.persistenceUnitName = GenericDAO.PERSISTUNIT;
    }

    
    public BO(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public GenericDAO<E> getDao() {
        if (this.dao == null) {
            this.dao = new GenericDAO<E>(persistenceUnitName);
        }
        return this.dao;
    }

    public E find(E entity) throws Exception {
        return getDao().find(entity);
    }

    public E find(Object primaryKey) throws Exception {
        return getDao().find(getClazz(), primaryKey);
    }

    public boolean refresh(E entity) throws Exception {
        return getDao().refresh(entity);
    }
    
    public boolean persist(E entity) throws Exception {
        if (getDao().find(entity) != null){
            return getDao().merge(entity);
        } else {
        	log.warn("Persist: " + entity.getClass().toString());
            return getDao().persist(entity);
        }
    }
    public boolean merge(E entity) throws Exception {
        return getDao().merge(entity);
    }

    public void persistBatch(List<E> entities) throws Exception {
        getDao().persistBatch(entities);
    }

    public void mergeBatch(List<E> entities) throws Exception {
        getDao().mergeBatch(entities);
    }

    public boolean remove(E entity) throws Exception {
        return getDao().remove(entity);
    }

    public List<E> list(final String jpql) throws Exception {
        return getDao().list(jpql);
    }

    public List<E> list(final Query jpql) throws Exception {
        return getDao().list(jpql);
    }

    public List<E> listAll() throws Exception {
        return getDao().listAll(getClazz());
    }

    public Class<E> getClazz() {
        return clazz;
    }

    public void setClazz(Class<E> clazz) {
        this.clazz = clazz;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    protected E findByFields(Map<String, Object> filtros) throws Exception {
        return getDao().findByFields(clazz, filtros);
    }

    protected List<E> listByFields(Map<String, Object> filtros, String[] ordenacao) throws Exception {
        return getDao().listByFields(clazz, filtros, ordenacao);
    }

    protected List<E> listByFields(Map<String, Object> filtros) throws Exception {
        return listByFields(filtros, null);
    }

    public List<Object[]> listArrayObjects(Query jpql) throws Exception {
        List<Object[]> list = null;
        try {
            list = getDao().listArrayObjects(jpql);
        } catch (Exception e) {
            log.error("Erro no list", e);
            throw e;
        }
        return list;
    }
}
