package com.megaProject.OnlineFoodOrder.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Helper.OTPGenerator;
import com.megaProject.OnlineFoodOrder.Jwt.JwtUtils;
import com.megaProject.OnlineFoodOrder.Request.LoginRequest;
import com.megaProject.OnlineFoodOrder.Response.JwtResponse;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Services.EmailService;
import com.megaProject.OnlineFoodOrder.Services.JwtBlacklistService;
import com.megaProject.OnlineFoodOrder.Services.OTPService;
import com.megaProject.OnlineFoodOrder.Services.UserDetailsImpl;
import com.megaProject.OnlineFoodOrder.Services.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	CrudRepository userRepository;

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
	JwtBlacklistService blacklistService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getFirst_name(),HttpStatus.OK));
	}
	
	//@GetMapping("/logout")
	//public MessageResponse logout() {
		//blacklistService.logout();
		//return null;
		
	//}
	
}
