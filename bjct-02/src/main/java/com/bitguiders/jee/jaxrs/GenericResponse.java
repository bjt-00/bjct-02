package com.bitguiders.jee.jaxrs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class GenericResponse {

	private String id;
	private String message;
	private boolean success;
	private List<?> data;

	public GenericResponse() {}
	public GenericResponse(String id, String message, boolean success) {
		super();
		this.id = id;
		this.message = message;
		this.success = success;
	}

	public GenericResponse(String id, String message, boolean success, List<?> data) {
		super();
		this.id = id;
		this.message = message;
		this.success = success;
		this.data = data;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
}
