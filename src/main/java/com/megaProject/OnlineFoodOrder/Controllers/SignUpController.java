 package com.megaProject.OnlineFoodOrder.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.model.InternalServerErrorException;
import com.megaProject.OnlineFoodOrder.Helper.OTPGenerator;
import com.megaProject.OnlineFoodOrder.Jwt.JwtUtils;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;
import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.Services.EmailService;
import com.megaProject.OnlineFoodOrder.Services.OTPService;
import com.megaProject.OnlineFoodOrder.Services.UserService;
import com.megaProject.OnlineFoodOrder.Services.UsersRepoService;
import com.megaProject.OnlineFoodOrder.models.User;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SignUpController {
	
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserService service;
	
	@Autowired
	OTPGenerator otpGenerator;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	OTPService otpService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UsersRepoService repoService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> CreateAccount(@RequestBody User users)
	{
		return(repoService.CreateAccount1(users));
	}
	
	@PostMapping("/verifyOtp")
	public ResponseEntity<?>verifyOTP(@RequestBody OtpRequest otpRequest)
	{
		return(this.repoService.verifyotp(otpRequest));
	}
	
	@PostMapping("/resendOtp")
	public ResponseEntity<?> ResendOTP(@RequestBody User users)
	{
		//String password=users.getPassword();
		//users.setPassword(encoder.encode(password));
		return(repoService.ResendOTP(users));
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<?> CreateAccount2(@RequestBody User users)
	{
		String password=users.getPassword();
		users.setPassword(encoder.encode(password));
		return(repoService.CreateAccount2(users));
	}
	

}
