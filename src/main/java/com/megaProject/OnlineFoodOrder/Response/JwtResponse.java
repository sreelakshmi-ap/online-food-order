package com.megaProject.OnlineFoodOrder.Response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String First_name;
	private HttpStatus responseStatus;
	
	
	

	public JwtResponse(String token, String first_name, HttpStatus responseStatus) {
		super();
		this.token = token;
		First_name = first_name;
		this.responseStatus = responseStatus;
	}

//	public JwtResponse(String accessToken, String First_name) {
//		this.token = accessToken;
//		this.First_name = First_name;
//	}

//	public String getAccessToken() {
//		return token;
//	}
//
//	public void setAccessToken(String accessToken) {
//		this.token = accessToken;
//	}

//	public String getTokenType() {
//		return type;
//	}
//
//	public void setTokenType(String tokenType) {
//		this.type = tokenType;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	
	
	

	
}
