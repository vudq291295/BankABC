package org.IntegrateService.PurchasePrepaidDataSIM.Model;

import java.io.Serializable;

public class LoginRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String phonenumber;
	private String password;
	
	//need default constructor for JSON Parsing
	public LoginRequest()
	{
		
	}

	public LoginRequest(String phonenumber) {
		super();
		this.phonenumber = phonenumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

//	public LoginRequest(String username, String password) {
//		this.setUsername(username);
//		this.setPassword(password);
//	}
//
//	public String getUsername() {
//		return this.username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}