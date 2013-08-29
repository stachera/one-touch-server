package com.up.onetouch.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.up.onetouch.bean.TipoServico;
import com.up.onetouch.bo.TipoServicoBO;

@ManagedBean
@ViewScoped
public class TipoServicoMB extends DefaultBean<TipoServico> {

	private static final long serialVersionUID = 1L;

	public TipoServicoMB() {
		super(new TipoServicoBO());
		setClazz(TipoServico.class);		
	}
}