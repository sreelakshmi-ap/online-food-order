package com.megaProject.OnlineFoodOrder.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Request.editUserDetailsRequest;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.UserDetailsResponse;
import com.megaProject.OnlineFoodOrder.Services.LoggedinUserService;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
	
	@Autowired
	LoggedinUserService userService;
	
	@GetMapping("/getUserDetails")
	public UserDetailsResponse getUserDetails() {
		return userService.getUserDetails();
	}
	
	@PutMapping("/editUserDetails")
	public MessageResponse editUserDetails(@RequestBody editUserDetailsRequest editUser) {
		userService.editUserDetails(editUser);
		return new MessageResponse("user details updated successfully!",HttpStatus.OK);
	}
	}



