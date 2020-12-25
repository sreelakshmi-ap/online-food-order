package com.megaProject.OnlineFoodOrder.Request;

public class editUserDetailsRequest {
	
	String first_name;
	String last_name;
	long phone_number;
	
	public editUserDetailsRequest(String first_name, String last_name, long phone_number) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
	}

	public editUserDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	
	
	

}
