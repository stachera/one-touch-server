package com.up.onetouch.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Usuario;
import com.up.onetouch.dao.GenericDAO;

public class UsuarioBO extends BO<Usuario>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(UsuarioBO.class);

	public UsuarioBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(Usuario.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Usuario getByLogin(String login) throws Exception {
		Map<String, Object> filtros = new HashMap<String, Object>();
		Usuario usr = null;

		filtros.put("login", login);		
		usr = findByFields(filtros);
		
		return usr;
	}
	
	@Override
	public boolean persist(Usuario entity) throws Exception {
		
		boolean validate = true;
		
		if(entity.getId() == 0){		
			if(entity.getLogin() == null || entity.getLogin().isEmpty()){
				validate = false;
			}
			if(entity.getSenha() == null || entity.getSenha().isEmpty()){
				validate = false;
			}
		}	
		
		if(validate){
			return super.persist(entity);	
		} 
		return false;
	}
}
