package com.megaProject.OnlineFoodOrder.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brands {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer brand_id;
	
	private String brand_name;
	private String city;
	private String title;
	private String description;
	private String logo_image_path;
	private String food_image_path;
	
	public Brands() {}
	
	public Brands(String brand_name, String city, String title, String description, String logo_image_path,
			String food_image_path) {
		this.brand_name = brand_name;
		this.city = city;
		this.title = title;
		this.description = description;
		this.logo_image_path = logo_image_path;
		this.food_image_path = food_image_path;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo_image_path() {
		return logo_image_path;
	}
	public void setLogo_image_path(String logo_image_path) {
		this.logo_image_path = logo_image_path;
	}
	public String getFood_image_path() {
		return food_image_path;
	}
	public void setFood_image_path(String food_image_path) {
		this.food_image_path = food_image_path;
	}
}
