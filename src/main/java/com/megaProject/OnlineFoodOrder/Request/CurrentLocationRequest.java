package com.megaProject.OnlineFoodOrder.Request;

public class CurrentLocationRequest {
	double latitude;
	double longitude;
	String searchBy;
	String city;
	
	public CurrentLocationRequest(double latitude, double longitude, String searchBy, String city) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.searchBy = searchBy;
		this.city = city;
	}

	public CurrentLocationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	      
	
	

}
