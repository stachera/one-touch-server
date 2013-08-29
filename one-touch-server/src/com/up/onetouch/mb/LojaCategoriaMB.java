package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.LojaCategoria;
import com.up.onetouch.bo.LojaCategoriaBO;

@ManagedBean
@ViewScoped
public class LojaCategoriaMB extends DefaultBean<LojaCategoria> {

	private static final long serialVersionUID = 1L;

	public LojaCategoriaMB() {
		super(new LojaCategoriaBO());
		setClazz(LojaCategoria.class);		
	}
}