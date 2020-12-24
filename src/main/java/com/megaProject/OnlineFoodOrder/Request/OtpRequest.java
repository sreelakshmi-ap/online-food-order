package com.megaProject.OnlineFoodOrder.Request;

public class OtpRequest {
	
	
	private String otp;
	
	private String email;
	
	
	

	public OtpRequest() {
		super();
	}




	public OtpRequest(String otp, String email) {
		super();
		this.otp = otp;
		this.email = email;
	}




	public String getOtp() {
		return otp;
	}




	public void setOtp(String otp) {
		this.otp = otp;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

}
