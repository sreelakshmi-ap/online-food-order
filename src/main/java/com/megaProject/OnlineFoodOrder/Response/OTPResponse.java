package com.megaProject.OnlineFoodOrder.Response;

import org.springframework.http.HttpStatus;

public class OTPResponse {
	
	private String message;
	
	private int user_id;
	
	private String email;
	
	private HttpStatus responseStatus;
	
	
	
	

	public OTPResponse() {
		super();
	}





	public OTPResponse(String message, int user_id, String email, HttpStatus responseStatus) {
		super();
		this.message = message;
		this.user_id = user_id;
		this.email = email;
		this.responseStatus = responseStatus;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public int getUser_id() {
		return user_id;
	}





	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public HttpStatus getResponseStatus() {
		return responseStatus;
	}





	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
