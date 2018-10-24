package com.bitguiders.jee.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserResource {
	
	private String message;
	private boolean success;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<UserModel> get(){
		List<UserModel> usersList = new ArrayList<UserModel>();
		
		usersList.add(new UserModel("Abdul Kareem","03015421954","ak"));
		usersList.add(new UserModel("Waqas Ahmed","03335078671","waqas"));
		
		return usersList;
	}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public UserModel get(@PathParam("id")String id){
		return new UserModel("Abdul Kareem","03015421954",id);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public GenericResponse create(UserModel userModel) {
		
		message ="Given User "+userModel.getName()+" created successfully";
		success=true;
		
		return new GenericResponse(userModel.getId(),message,success);
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public GenericResponse update(UserModel userModel) {
		
		message ="Given User "+userModel.getName()+" created successfully";
		success=true;
		
		return new GenericResponse(userModel.getId(),message,success);
	}

	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public GenericResponse delete(@PathParam("id")String id) {
		
		message ="Given User "+id+" deleted successfully";
		success=true;
		
		return new GenericResponse(id,message,success);
	}

}
