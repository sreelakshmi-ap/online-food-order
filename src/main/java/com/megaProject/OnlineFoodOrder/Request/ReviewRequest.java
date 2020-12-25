package com.megaProject.OnlineFoodOrder.Request;

import java.time.LocalDate;

public class ReviewRequest {
	
	int food_rating;
	int service_rating;
	String description;
	LocalDate date;
	
	
	public ReviewRequest(int food_rating, int service_rating, String description, LocalDate date) {
		this.food_rating = food_rating;
		this.service_rating = service_rating;
		this.description = description;
		this.date = date;
		
	}
	public int getFood_rating() {
		return food_rating;
	}
	public void setFood_rating(int food_rating) {
		this.food_rating = food_rating;
	}
	public int getService_rating() {
		return service_rating;
	}
	public void setService_rating(int service_rating) {
		this.service_rating = service_rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
