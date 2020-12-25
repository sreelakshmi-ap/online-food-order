
package com.megaProject.OnlineFoodOrder.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Request.OtpRequest;
import com.megaProject.OnlineFoodOrder.Request.PasswordRequest;
import com.megaProject.OnlineFoodOrder.Services.ForgotpwdService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {
	
	@Autowired
	ForgotpwdService forgotpwdService;
	
	@PostMapping("/forgotPassword")
	ResponseEntity<?> Forgotpassword(@RequestParam String email)
	{
		return(forgotpwdService.ForgotPassword(email));
	}
	
	@PostMapping("/enterOtp")
	ResponseEntity<?> EnterOtp(@RequestBody OtpRequest otpRequest)
	{
		return(forgotpwdService.verifyOtp(otpRequest));
	}
	
	@PostMapping("/changePassword")
	ResponseEntity<?> Changepassword(@RequestParam String email,@RequestBody PasswordRequest passwordRequest)
	{
		return(forgotpwdService.changepassword(email, passwordRequest));
	}
	

}
