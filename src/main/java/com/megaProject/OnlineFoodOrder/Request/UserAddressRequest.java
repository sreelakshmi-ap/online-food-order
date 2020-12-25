package com.megaProject.OnlineFoodOrder.Request;

public class UserAddressRequest {
	private String city;

	private String area;

	private String address;

	private String address_label;

	private String landmark;

	public UserAddressRequest(String city, String area, String address, String address_label, String landmark) {
		super();
		this.city = city;
		this.area = area;
		this.address = address;
		this.address_label = address_label;
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_label() {
		return address_label;
	}

	public void setAddress_label(String address_label) {
		this.address_label = address_label;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}
