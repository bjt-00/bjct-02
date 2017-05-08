package com.bitguiders.jee7.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/jaxrs")
public class MyRestService {
	
	@GET
	@Path("/html")
	public String getHtml(){
		return "html msg from rest service";
	}
}
