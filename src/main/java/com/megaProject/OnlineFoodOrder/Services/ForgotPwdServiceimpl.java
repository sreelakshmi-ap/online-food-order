package com.megaProject.OnlineFoodOrder.Services;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.Helper.OTPGenerator;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;
import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.Request.PasswordRequest;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.OTPResponse;
import com.megaProject.OnlineFoodOrder.Response.SignupWithEmailResponse;
import com.megaProject.OnlineFoodOrder.models.User;

@Service
public class ForgotPwdServiceimpl implements ForgotpwdService{
	
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	private OTPService userService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	OTPGenerator otpGenerator;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();
    LocalTime expireTime2;
    LocalTime time2;

	@Override
	public ResponseEntity<?> ForgotPassword(String userEmail) {
		
		//Optional<User> optional = userService.findUserByEmail(userEmail);
		System.out.println(userEmail);
		User userbyemail=repo.FindUserByEmail(userEmail);
		System.out.println(userEmail);

		if (userbyemail==null) {
			return ResponseEntity.badRequest().body(new MessageResponse("User Not found",HttpStatus.BAD_REQUEST));
		} else {

			//User user1 = optional.get();
			 String OTP= otpGenerator.generateRandomSpecialCharacters(6);
			 System.out.println(OTP);
			 userbyemail.setOTP(OTP);

			userService.save(userbyemail);
			
			time2=java.time.LocalTime.now();
		    System.out.println(java.time.LocalTime.now());
		    
		    expireTime2=java.time.LocalTime.now().plusMinutes(5);
		    System.out.println(expireTime2);

			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("sowjanyaminion@gmail.com");
			passwordResetEmail.setTo(userbyemail.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail
					.setText(userbyemail.getFirst_name()+" Please Enter This OTP For Verification " + userbyemail.getOTP());

			emailService.sendEmail(passwordResetEmail);
			return ResponseEntity.ok(new SignupWithEmailResponse("OTP Sent to Mail "+userbyemail.getEmail(),userbyemail.getEmail(),HttpStatus.OK));
		}
		
	}

	@Override
	public ResponseEntity<?> verifyOtp(OtpRequest otpRequest) {
		User Findotpuser=repo.FindUserByOtp(otpRequest.getOtp());
		
		if(Findotpuser==null)
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid OTP", HttpStatus.NOT_FOUND));
		}
		
		if(Findotpuser.getEmail().equals(otpRequest.getEmail()))
		{
			int value = expireTime2.compareTo(java.time.LocalTime.now());
			if(value<0)
			{
				Findotpuser.setOTP(null);
				//users1.setOTP(null);
				//users11.setOTP(null);
				return ResponseEntity.badRequest().body(new MessageResponse("OTP Expired",HttpStatus.BAD_GATEWAY));
			}
			String OTP2=Findotpuser.getOTP();
			if(otpRequest.getOtp().equals(null))
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			if (Findotpuser!=null) {
				Findotpuser.setOTP(null);
				//users1.setOTP(null);
				return ResponseEntity.ok(new OTPResponse("User Verified Successfully",Findotpuser.getUser_id(),Findotpuser.getEmail(),HttpStatus.OK));
			} 
		}
		
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid OTP", HttpStatus.NOT_FOUND));
	
		
		
	}

	@Override
	public ResponseEntity<?> changepassword(String email, PasswordRequest passwordRequest) {
		Optional<User> user2 = userService.findUserByEmail(email);

		if (!user2.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("User Not found",HttpStatus.BAD_REQUEST));
		} 
		else {
			
			User user1 = user2.get();
			//user1.setPassword(passwordRequest.getPassword());
			
			String password=bCryptPasswordEncoder.encode(passwordRequest.getPassword());
			System.out.println(passwordRequest.getPassword());
			user1.setPassword(password);
			repo.save(user1);
			return ResponseEntity.ok(new MessageResponse("Password has been Changed", HttpStatus.OK));
		}
		
	}

}
