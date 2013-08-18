package com.up.onetouch.service;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import com.up.onetouch.bean.LoginRequest;
import com.up.onetouch.bean.LoginResponse;
import com.up.onetouch.bean.Usuario;
import com.up.onetouch.bean.UsuarioResponse;
import com.up.onetouch.bo.LoginBO;
import com.up.onetouch.bo.UsuarioBO;
import com.up.onetouch.constants.Mensagens;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioService {
 
	@POST
	@Path("/persist")	
	public Response persist(Usuario usuario) {
 
		UsuarioResponse response = new UsuarioResponse();
		
		try {
			UsuarioBO bo = new UsuarioBO();
			if(bo.persist(usuario)){	
				response.setMensagem(Mensagens.PERSISTE_OK);
				return Response.status(200).entity(response).build();	
			}
		} catch (Exception e) {
			response.setMensagem(Mensagens.ERRO_BD);
			e.printStackTrace();
		}
		
		return Response.status(500).entity(response).build();
	}
	 
}