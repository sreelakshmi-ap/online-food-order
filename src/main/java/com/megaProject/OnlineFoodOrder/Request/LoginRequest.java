package com.megaProject.OnlineFoodOrder.Request;


import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class LoginRequest {
	@NotBlank
	private String email;

	@NotBlank
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
