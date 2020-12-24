package com.megaProject.OnlineFoodOrder.Services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.megaProject.OnlineFoodOrder.repository.UserRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.OTPResponse;
import com.megaProject.OnlineFoodOrder.Response.SignupMessage;
import com.megaProject.OnlineFoodOrder.Response.SignupWithEmailResponse;
import com.megaProject.OnlineFoodOrder.Response.UserMessage;
import com.megaProject.OnlineFoodOrder.models.User;


@Service
public class UsersRepoServiceImpl implements UsersRepoService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	OTPService otpService;
	
	
	@Autowired
	EmailService emailService;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date = new Date();
    LocalTime expireTime;
    LocalTime time1;

	public ResponseEntity<?> CreateAccount1(User users) {
		// TODO Auto-generated method stub
		
		if (repo.existsByEmail(users.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!",HttpStatus.BAD_REQUEST));
	}
		
	    	String OTP= generateRandomSpecialCharacters(6);
			users.setOTP(OTP);
			
			time1=java.time.LocalTime.now();
		    System.out.println(java.time.LocalTime.now());
		    
		    expireTime=java.time.LocalTime.now().plusMinutes(5);
		    System.out.println(expireTime);
		    
		    repo.save(users);
	        
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("sowjanyaminion@gmail.com");
			passwordResetEmail.setTo(users.getEmail());
			passwordResetEmail.setSubject("Email verification OTP");
			passwordResetEmail
					.setText("Your OTP for EMAIL VERIFICATION is:"+ users.getOTP());
			System.out.println(OTP);

			emailService.sendEmail(passwordResetEmail);
			
		    return ResponseEntity.ok(new SignupWithEmailResponse("User Email Added",users.getEmail(),HttpStatus.OK));
	}
	
	
	
	
//	public ResponseEntity<?> verifyEmail(@RequestBody OtpRequest otpRequest) {
//
//		Optional<User> user1 = otpService.findUserByOTP(otpRequest.getOTP());
//		System.out.println(user1);
//
//		if (user1.isPresent()) {
//			return ResponseEntity.ok(new MessageResponse("OTP for user verified successfully!"));
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}
	
	public ResponseEntity<?> verifyotp(OtpRequest otpRequest)
	{
		//Users users2=repo.FindUsersByOtp(OTP);
		
		User Findotpuser=repo.FindUserByOtp(otpRequest.getOtp());
		
		if(Findotpuser==null)
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid OTP", HttpStatus.NOT_FOUND));
		}
		
		//Optional<User> user1 = otpService.findUserByOTP(otpRequest.getOTP());
		//User users1=user1.get();
		
		if(Findotpuser.getEmail().equals(otpRequest.getEmail()))
		{
			int value = expireTime.compareTo(java.time.LocalTime.now());
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

//	@Override
//	public void times() {
//		// TODO Auto-generated method stub
//		
//		time1=java.time.LocalTime.now();
//	    System.out.println(java.time.LocalTime.now());
//	    
//	    expireTime=java.time.LocalTime.now().plusMinutes(1);
//	    System.out.println(expireTime);
//	}
//	
//	public String verify()
//	{
//		int value = expireTime.compareTo(java.time.LocalTime.now());
//		if(value<0)
//		{
//			return "Time out";
//		}
//		return "Success";
//		
//	}

	@Override
	public ResponseEntity<?> CreateAccount2(User users) {
		// TODO Auto-generated method stub
		repo.save(users);
		return ResponseEntity.ok(new SignupMessage("User Added Successfully", users.getUser_id(),users.getEmail(),users.getFirst_name(),users.getLast_name(),users.getCountry_code(),users.getMobile_number(),HttpStatus.OK));
	}
	
	
	public String generateRandomSpecialCharacters(int len){
		StringBuilder generatedOTP = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();

		try {

		    secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

		    for (int i = 0; i < len; i++) {
		        generatedOTP.append(secureRandom.nextInt(9));
		    }
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}

		return generatedOTP.toString();

	}

	@Override
	public ResponseEntity<?> ResendOTP(User users2) {
		String OTP= generateRandomSpecialCharacters(6);
		
		User resendUser = repo.FindUserByEmail(users2.getEmail());
        
		SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
		passwordResetEmail.setFrom("vinorakodiya@gmail.com");
		passwordResetEmail.setTo(users2.getEmail());
		passwordResetEmail.setSubject("Email verification OTP");
		passwordResetEmail
				.setText("Your OTP for EMAIL VERIFICATION is:"+ users2.getOTP());
		System.out.println(OTP);

		emailService.sendEmail(passwordResetEmail);
		
		time1=java.time.LocalTime.now();
	    System.out.println(java.time.LocalTime.now());
	    
	    expireTime=java.time.LocalTime.now().plusMinutes(5);
	    System.out.println(expireTime);
	    
	    resendUser.setOTP(OTP);
	    repo.save(resendUser);
	    
	   
	//	String OTP2=users2.getOTP();
		return ResponseEntity.ok(new OTPResponse("Email Sent to "+users2.getEmail(),users2.getUser_id(),users2.getEmail(),HttpStatus.OK));
	    //return ResponseEntity.ok(new MessageResponse("OTP Sent"));
	}
	

}
