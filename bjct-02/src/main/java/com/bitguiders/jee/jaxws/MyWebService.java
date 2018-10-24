package com.bitguiders.jee.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="myWebService")
public class MyWebService {

	@WebMethod
	public String getHtml(String name){
		return "Welcome "+name;
	}
}
