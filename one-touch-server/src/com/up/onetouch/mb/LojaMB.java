package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Loja;
import com.up.onetouch.bo.LojaBO;

@ManagedBean
@ViewScoped
public class LojaMB extends DefaultBean<Loja> {

	private static final long serialVersionUID = 1L;

	public LojaMB() {
		super(new LojaBO());
		setClazz(Loja.class);		
	}
}