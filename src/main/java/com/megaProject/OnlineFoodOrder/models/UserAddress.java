package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_address")
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int address_id;

	private int user_id;

	private String city;

	private String area;

	private String address;

	private String address_label;

	private String landmark;

	private boolean primary_address;
	
	public UserAddress() {
		super();
	}

	public UserAddress(int address_id, int user_id, String city, String area, String address, String address_label,
			String landmark, boolean primary_address) {
		super();
		this.address_id = address_id;
		this.user_id = user_id;
		this.city = city;
		this.area = area;
		this.address = address;
		this.address_label = address_label;
		this.landmark = landmark;
		this.primary_address = primary_address;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public boolean isPrimary_address() {
		return primary_address;
	}

	public void setPrimary_address(boolean primary_address) {
		this.primary_address = primary_address;
	}


}
