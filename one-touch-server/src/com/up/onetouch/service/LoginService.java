package com.up.onetouch.service;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.up.onetouch.bean.LoginRequest;
import com.up.onetouch.bean.LoginResponse;
import com.up.onetouch.bo.LoginBO;

@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginService {
 
	@POST
	@Path("/validate")	
	public Response validate(LoginRequest login) {
 
		LoginBO bo = new LoginBO();
		LoginResponse response = bo.validate(login);
		
		return Response.status(200).entity(response).build();
	}
	
	@GET
	@Path("/test")
	public Response test() {
		return Response.status(200).build();
	}
 
}