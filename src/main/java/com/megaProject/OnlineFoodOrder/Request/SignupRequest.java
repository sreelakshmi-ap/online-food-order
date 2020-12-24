package com.megaProject.OnlineFoodOrder.Request;

import java.util.Set;

import javax.validation.constraints.*;

import org.springframework.stereotype.Component;

@Component
public class SignupRequest {
	@NotBlank
	@Size(max = 40)
	@Email
	public String email;

	@NotBlank
	@Size(max = 20)
	private String first_name;

	@NotBlank
	@Size(max = 20)
	private String last_name;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@NotBlank
	@Size(max = 4)
	private String country_code;
	
	@NotBlank
	private long mobile_number ;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	
	
}
