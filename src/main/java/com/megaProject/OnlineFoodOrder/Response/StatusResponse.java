package com.megaProject.OnlineFoodOrder.Response;

public class StatusResponse {
	
	int status_code;
	String message;
	
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StatusResponse(int status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}
	
	
	
}
