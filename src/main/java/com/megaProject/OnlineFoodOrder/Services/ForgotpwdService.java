package com.megaProject.OnlineFoodOrder.Services;

import org.springframework.http.ResponseEntity;

import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.Request.PasswordRequest;

public interface ForgotpwdService {
	
	
	public ResponseEntity<?> ForgotPassword(String userEmail);
	
	public ResponseEntity<?> verifyOtp(OtpRequest otpRequest);
	
	public ResponseEntity<?> changepassword(String email,PasswordRequest passwordRequest);

}
