package com.megaProject.OnlineFoodOrder.Services;

import org.springframework.http.ResponseEntity;

import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.models.User;



public interface UsersRepoService {
	
	public ResponseEntity<?> CreateAccount1(User users);
	
	public  ResponseEntity<?> CreateAccount2(User users);

	
	public ResponseEntity<?> verifyotp(OtpRequest otpRequest);
	
	public ResponseEntity<?> ResendOTP(User users);

}