package com.up.onetouch.phaselistener;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.up.onetouch.mb.LoginMB;
import com.up.onetouch.util.Navigation;

public class LoginPhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext fc = event.getFacesContext();
		ExternalContext ec = fc.getExternalContext();
		
		if(fc.getViewRoot().getViewId().lastIndexOf("login.xhtml") == -1){	
			boolean isLogged = true;
			if(!ec.getSessionMap().isEmpty()){
				LoginMB loginMB = (LoginMB) ec.getSessionMap().get("loginMB");
				System.out.println("loginMB: " + loginMB);
				if(loginMB != null)
					loginMB.isLogged();
				else
					isLogged = false;
			} else {
				isLogged = false;
			}
			
			if(isLogged == false)
				Navigation.redirectLocalPage("login");
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
