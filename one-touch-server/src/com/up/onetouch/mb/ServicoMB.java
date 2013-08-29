package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.Servico;
import com.up.onetouch.bo.ServicoBO;

@ManagedBean
@ViewScoped
public class ServicoMB extends DefaultBean<Servico> {

	private static final long serialVersionUID = 1L;

	public ServicoMB() {
		super(new ServicoBO());
		setClazz(Servico.class);		
	}
}