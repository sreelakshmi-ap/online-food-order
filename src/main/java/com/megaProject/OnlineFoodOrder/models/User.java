package com.megaProject.OnlineFoodOrder.models;

import java.sql.Time;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;

@Component
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email") })

public class User {

	@Id
	private int user_id;

	@NotBlank
	@Size(max = 40)
	@Email
	public String email;

	private String first_name;

	@NotBlank
	@Size(max = 20)
	private String last_name;

	private String password;
	
	private String country_code;
	
	private long mobile_number ;
	
	@NotBlank
	@Size(max = 40)
	private String image_path;

	private String OTP;

	private float latitude;

	private float longitude;

	@Size(max = 25)
	private String city;

	private Time OTP_generation_time;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email) {
		this.email=email;
		
	}

	public User(int user_id, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(max = 20) String first_name,
			@NotBlank @Size(max = 20) String last_name, @NotBlank @Size(max = 120) String password,
			@NotBlank @Size(max = 4) String country_code, @NotBlank long mobile_number,
			@NotBlank @Size(max = 40) String image_path, @NotBlank String oTP, @NotBlank float latitude,
			@NotBlank float longitude, @NotBlank @Size(max = 25) String city,
			@NotBlank @Size(max = 4) Time oTP_generation_time) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.country_code = country_code;
		this.mobile_number = mobile_number;
		this.image_path = image_path;
		OTP = oTP;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		OTP_generation_time = oTP_generation_time;
	}
	
	

	public User(@NotBlank @Size(max = 20) String first_name, @NotBlank @Size(max = 20) String last_name,
			 @NotBlank @Size(max = 4) String country_code,@NotBlank long mobile_number,@NotBlank @Size(max = 120) String password) {
		super();
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.country_code = country_code;
		this.mobile_number = mobile_number;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

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

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getOTP() {
		return OTP;
	}

	public void setOTP(String oTP) {
		OTP = oTP;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Time getOTP_generation_time() {
		return OTP_generation_time;
	}

	public void setOTP_generation_time(Time oTP_generation_time) {
		OTP_generation_time = oTP_generation_time;
	}
	
	

}	