package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Usuario;
import com.up.onetouch.bo.UsuarioBO;

@ManagedBean
@ViewScoped
public class UsuarioMB extends DefaultBean<Usuario> {

	private static final long serialVersionUID = 1L;

	public UsuarioMB() {
		super(new UsuarioBO());
		setClazz(Usuario.class);		
	}
}