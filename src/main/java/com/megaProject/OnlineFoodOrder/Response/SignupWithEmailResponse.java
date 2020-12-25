package com.megaProject.OnlineFoodOrder.Response;

import org.springframework.http.HttpStatus;



public class SignupWithEmailResponse {
	
	private String message;
	
	private String email;
	
	private HttpStatus responseStatus;
	
	
	
	

	public SignupWithEmailResponse() {
		super();
	}





	public SignupWithEmailResponse(String message, String email, HttpStatus responseStatus) {
		super();
		this.message = message;
		this.email = email;
		this.responseStatus = responseStatus;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
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
