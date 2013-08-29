package com.up.onetouch.mb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.up.onetouch.bo.BO;

public abstract class DefaultBean<E extends Serializable> implements Serializable {
    private static final long serialVersionUID = 1L;

    private BO<E> bO;

    private Class<E> clazz;

    private E entity;

    private transient Logger log = Logger.getLogger(DefaultBean.class);

    private List<E> entityList;
    
    private E entitySelect;
    
    @PostConstruct
    public void init() {
        getEntity();            
    }

    public DefaultBean(BO<E> bO) {
        this.setbO(bO);
    }

    public Class<E> getClazz() {
        return clazz;
    }

    public void setClazz(Class<E> clazz) {
        this.clazz = clazz;
        this.getbO().setClazz(clazz);
    }

    public E getEntity() {
        if (entity == null) {
            try {
                // entity = (E) Class.forName(getClazz().getName()).newInstance();
                entity = (E) clazz.newInstance();
            } catch (Exception e) {
                log.error("Erro no getEntity", e);
            }
        }
        return entity;
    }

    public void setEntity(E entity) {
    	System.out.println("setEntity:" + entity);
        this.entity = entity;
    }

    public void actionNew(ActionEvent event) {
    	setEntity(null);
        setEntitySelect(null);
    }

    public void actionPersist(ActionEvent event) {
        try {
        	if (getbO().persist(getEntity())) {
                actionNew(event);
                setEntityList(null);
            }
            addInfo("Registro salvo com sucesso", "");
        } catch (Exception e) {
            log.error("Erro no actionPersist", e);
            addError("Erro ao salvar registro", "");
        }
    }

    public void actionRemove(ActionEvent event) {
        try {
            if (getbO().remove(getEntity())) {
                actionNew(event);
                setEntityList(null);
            }
            addInfo("Registro removido com sucesso", "");
        } catch (Exception e) {
            log.error("Erro no actionRemove", e);
            addError("Erro ao remover registro", "");
        }
    }
       
    public List<E> getEntityList() {
        try {
            if (entityList == null)
                entityList = getbO().listAll();
        } catch (Exception e) {
            log.error("Erro no getEntityList", e);
            addError("Erro ao buscar registros", "");
        }
        return entityList;
    }

    public void setEntityList(List<E> entityList) {
        this.entityList = entityList;
    }
    
    public E getEntitySelect() {
		return entitySelect;
	}

	public void setEntitySelect(E entitySelect) {
		if(entitySelect != null){			
			this.entity = entitySelect;
		}
		this.entitySelect = entitySelect;
	}

	public void validationFailed(FacesContext context, UIComponent validate) {
        ((UIInput) validate).setValid(false);
        context.validationFailed();
        context.addMessage(validate.getClientId(context), new FacesMessage(((UIInput) validate).getValidatorMessage()));
    }

    public void addInfo(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    }

    public void addWarn(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
    }

    public void addError(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    public void addFatal(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
    }

    private void addMessage(Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

	public BO<E> getbO() {
		return bO;
	}

	public void setbO(BO<E> bO) {
		this.bO = bO;
	}	
}