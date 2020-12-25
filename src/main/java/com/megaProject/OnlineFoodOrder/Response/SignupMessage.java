package com.megaProject.OnlineFoodOrder.Response;

import org.springframework.http.HttpStatus;

import com.megaProject.OnlineFoodOrder.models.User;

public class SignupMessage {
	
	private String message;
	
	private int user_id;
	
	private String email;
	
	private String first_name;
	
	private String last_name;
	
	private String country_code;
	
	private Long mobile_number;
	
	private HttpStatus responseStatus;
	
	
	

	public SignupMessage() {
		super();
	}




	public SignupMessage(String message, int user_id, String email, String first_name, String last_name,
			String country_code, Long mobile_number, HttpStatus responseStatus) {
		super();
		this.message = message;
		this.user_id = user_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.country_code = country_code;
		this.mobile_number = mobile_number;
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




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getCountry_code() {
		return country_code;
	}




	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}




	public Long getMobile_number() {
		return mobile_number;
	}




	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}




	public HttpStatus getResponseStatus() {
		return responseStatus;
	}




	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	
	
	
	
	
	

}
