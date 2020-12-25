package com.megaProject.OnlineFoodOrder.Services;

import java.sql.Time;
import java.util.Collection;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megaProject.OnlineFoodOrder.models.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private int user_id;
	
	public String email;
	
	private String first_name;
	
	private String last_name;
	
	@JsonIgnore
	private String password;
	
	private String country_code;
	
	private long mobile_number ;
	
	private String image_path;
	
	private String OTP;
	
	private float latitude;
	
	private float longitude;
	
	private String city;
	
	private Time OTP_generation_time;
	
	

	public UserDetailsImpl(int user_id, String email, String first_name, String last_name, String password,
			String country_code, long mobile_number, String image_path, String oTP, float latitude, float longitude,
			String city, Time oTP_generation_time) {
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

	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(user.getUser_id(), user.getEmail(), user.getFirst_name(), user.getLast_name(),
				user.getPassword(),user.getCountry_code(),user.getMobile_number(),user.getImage_path(),user.getOTP(),
				user.getLatitude(),user.getLongitude(),user.getCity(),user.getOTP_generation_time());
	}

	


	public int getUser_id() {
		return user_id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getPassword() {
		return password;
	}


	public String getCountry_code() {
		return country_code;
	}

	
	public long getMobile_number() {
		return mobile_number;
	}


	public String getImage_path() {
		return image_path;
	}

	public String getOTP() {
		return OTP;
	}


	public float getLatitude() {
		return latitude;
	}


	public float getLongitude() {
		return longitude;
	}

	public String getCity() {
		return city;
	}

	
	public Time getOTP_generation_time() {
		return OTP_generation_time;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl that = (UserDetailsImpl) o;
		return Objects.equals(user_id, that.user_id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

}
