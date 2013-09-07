package com.up.onetouch.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.up.onetouch.bean.Loja;
import com.up.onetouch.bean.Produto;
import com.up.onetouch.dao.GenericDAO;

public class ProdutoBO extends BO<Produto>  {
	
	private static final long serialVersionUID = 1L;
	
	private transient Logger log = Logger.getLogger(ProdutoBO.class);

	public ProdutoBO() {
		setClazz(Produto.class);
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
	public List<Produto> listByLoja(Loja loja){
		Map<String, Object> filtros = new HashMap<String, Object>();
		filtros.put("lojaId", loja.getLojaId());
		
		List<Produto> list = null;
		try {
			list = listByFields(filtros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}