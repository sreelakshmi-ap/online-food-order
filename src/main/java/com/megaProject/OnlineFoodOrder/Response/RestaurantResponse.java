package com.megaProject.OnlineFoodOrder.Response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.megaProject.OnlineFoodOrder.models.Restaurants;

public class RestaurantResponse {

	private List<Restaurants> Restaurants;
	private HttpStatus responseStatus;
	private int noOfItems;

	public RestaurantResponse(List<Restaurants> restaurants, HttpStatus responseStatus, int noOfItems) {
		super();
		Restaurants = restaurants;
		this.responseStatus = responseStatus;
		this.noOfItems = noOfItems;
	}

	public List<Restaurants> getRestaurants() {
		return Restaurants;
	}

	public void setRestaurants(List<Restaurants> restaurants) {
		Restaurants = restaurants;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

}
