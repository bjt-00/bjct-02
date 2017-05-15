package com.bitguiders.ocejwcd6._07_jsp;

public class JSPBean {

	private String email;
	private String contactNumber;
	private String currentAction;

	public JSPBean(){
		System.out.println("JSPBean initialized....");
	}

	public String getEmail() {
		System.out.println("email getter called.....");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("email setter called.....");
		this.email = email;
		setCurrentAction(email);
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(String currentAction) {
		System.out.println("currentAction setter called....."+currentAction);
		this.currentAction = currentAction;
	}

	

}
