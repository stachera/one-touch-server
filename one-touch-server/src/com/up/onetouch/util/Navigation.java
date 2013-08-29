package com.up.onetouch.util;

import java.io.IOException;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;

public class Navigation {
	
	public Navigation() {
	}
	
	public static void redirectLocalPage(String page){
		FacesContext fc = FacesContext.getCurrentInstance();
    	ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
    	nav.performNavigation("/pages/" + page + "?faces-redirect=true");
	}
	
	public static void redirectPage(String page){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			fc.getExternalContext().redirect(fc.getExternalContext().getRequestContextPath() + "/pages/" + page);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
