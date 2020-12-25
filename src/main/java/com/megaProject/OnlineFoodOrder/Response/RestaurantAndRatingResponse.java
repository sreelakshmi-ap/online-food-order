package com.megaProject.OnlineFoodOrder.Response;

import java.util.List;

import com.megaProject.OnlineFoodOrder.models.Restaurants;

public class RestaurantAndRatingResponse {
	Restaurants restaurant;
	float rating;
	List<String> cuisines;
	
	public RestaurantAndRatingResponse(Restaurants restaurant, float rating) {
		this.restaurant = restaurant;
		this.rating = rating;
	}

	public RestaurantAndRatingResponse(Restaurants restaurant, float rating, List<String> cuisines) {
		this.restaurant = restaurant;
		this.rating = rating;
		this.cuisines = cuisines;
	}

	public List<String> getCuisines(){
		return cuisines;
	}

	public void setCuisines(List<String> cuisines) {
		this.cuisines = cuisines;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public RestaurantAndRatingResponse() {}

}

