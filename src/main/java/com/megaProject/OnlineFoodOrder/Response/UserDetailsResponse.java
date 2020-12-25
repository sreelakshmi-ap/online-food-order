package com.megaProject.OnlineFoodOrder.Response;

public class UserDetailsResponse {
	
	String first_name;
	String last_name;
	final String country_code = "+91";
	long phone_number;
	String email;
	String image_path;
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
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public String getCountry_code() {
		return country_code;
	}
	
	
	public UserDetailsResponse(String first_name, String last_name, long phone_number, String email,
			String image_path) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
		this.image_path = image_path;
	}
	public UserDetailsResponse() {}
	

}