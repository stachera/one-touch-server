package com.up.onetouch.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.up.onetouch.bean.Usuario;

import bo.SisUsuarioBO;

import util.MD5;
import util.Navigation;
import vo.SisUsuario;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public LoginMB() {
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    public void login() {    	
    	String senhaMD5 = MD5.stringToMD5(usuario.getSenha());
		usuario.setSenha(senhaMD5);
		
		usuario = (new SisUsuarioBO()).getUsuarioByLogin(usuario);
    	
    	if(usuario != null || usuario.getId() != 0){
        	Navigation.redirectLocalPage("main");
    	} else {        
        	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Usuário ou senha inválidos!");
        	FacesContext.getCurrentInstance().addMessage("form", msg);
        }    
    }
    
    public boolean isLogged(){
    	if(usuario != null){
	    	if(usuario.getId() == null || usuario.getId().equals(0)){	    		
	    		logout();
	    		return false;
	    	} else {
	    		return true;
	    	}
    	} else {
    		return false;
    	}
    }
    
    public void checkIsLogged(){
    	isLogged();
    }
    
    public void logout(){
    	FacesContext fc = FacesContext.getCurrentInstance();  
        HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
        session.invalidate();
        Navigation.redirectLocalPage("login");
    }
}
