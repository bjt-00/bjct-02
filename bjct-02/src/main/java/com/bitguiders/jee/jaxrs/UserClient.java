package com.bitguiders.jee.jaxrs;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



@Named
@Stateless
public class UserClient {
	protected Client client;
	//private static final Logger logger =Logger.getLogger(JAXRSClient.class.getName());
	@PostConstruct
	private void init() {
	System.out.println("post construct called");
	client = ClientBuilder.newClient();
	}
	@PreDestroy
	private void clean() {
	client.close();
	}
	
	public String createCustomer(UserModel UserORM) {
		if (UserORM == null) {
		//logger.log(Level.WARN, "customer is null.");
		return "UserORMForm";
		}
		String navigation;
		Response response =
		client.target("http://localhost:8080/jsf-master-piece/rest/UserORM/create")
		.request(MediaType.APPLICATION_XML)
		.post(Entity.entity(UserORM, MediaType.APPLICATION_XML),
		Response.class);
		if (response.getStatus() == Status.CREATED.getStatusCode()) {
		navigation = "UserORMList";
		} else {
		//logger.log(Level.WARN, "couldn''t create customer with ");// +
		//"id {0}. Status returned was {1}",
		//new Object[]{UserORM.getId(), response.getStatus()});
		navigation = "UserORMForm";
		}
		return navigation;
		}
	public String retrieveCustomer(String id) {
		String navigation;
		UserModel UserORM =
		client.target("http://localhost:8080/jsf-master-piece/rest/UserORM/xml")
		.path(id)
		.request(MediaType.APPLICATION_XML)
		.get(UserModel.class);
		if (UserORM == null) {
		navigation = "UserORMForm";
		} else {
		navigation = "UserORMList";
		}
		return navigation;
		}
	public List<UserModel> retrieveAllUserORMs() {
		List<UserModel> UserORM =
		client.target("http://localhost:8080/bjct-02/rest/user")
		//.path("user")
		.request(MediaType.APPLICATION_JSON)
		.get(new GenericType<List<UserModel>>() {});
		return UserORM;
		}
	
	public static void main(String arg[]){
		UserClient c = new UserClient();
		c.init();
		
		for(UserModel u:c.retrieveAllUserORMs()){
			//logger.info("-- "+u.getName());
			System.out.println("-- "+u.getName());
		}
	}
}
