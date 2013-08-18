package com.up.onetouch.bo;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.LoginRequest;
import com.up.onetouch.bean.LoginResponse;
import com.up.onetouch.bean.Usuario;
import com.up.onetouch.constants.Mensagens;
import com.up.onetouch.dao.GenericDAO;

public class LoginBO extends BO<Usuario>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(LoginBO.class);

	public LoginBO() {
		super(GenericDAO.PERSISTUNIT);
		setClazz(Usuario.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	public LoginResponse validate(LoginRequest login){
		LoginResponse response = new LoginResponse();
		try{
			UsuarioBO usuarioBO = new UsuarioBO();		
			Usuario usr = usuarioBO.getByLogin(login.getLogin());
			
			if(usr != null){
				if(login.getSenha().equals(usr.getSenha())){
					response.setUsuario(usr);
					response.setMensagem(Mensagens.LOGIN_OK);
				} else {
					response.setMensagem(Mensagens.ERRO_LOGIN_INVALIDO);	
				}
			} else {
				response.setMensagem(Mensagens.ERRO_LOGIN_INVALIDO);
			}		
		} catch(Exception e){
			response.setMensagem(Mensagens.ERRO_LOGIN_INVALIDO);
		}			
		return response;
	}
}
