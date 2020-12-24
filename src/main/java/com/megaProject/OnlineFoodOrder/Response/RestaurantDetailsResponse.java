package com.megaProject.OnlineFoodOrder.Response;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public class RestaurantDetailsResponse {
	
	String restaurant_name;
	LocalTime open_time;
	LocalTime close_time;
	int avg_delivery_time;
	int min_order_cost;
	String restaurant_image;
	
	
	List<String> cuisines;

	public RestaurantDetailsResponse(String restaurant_name, LocalTime open_time, LocalTime close_time,
			int avg_delivery_time, int min_order_cost,String restaurant_image, List<String> cuisines) {
		super();
		this.restaurant_name = restaurant_name;
		this.open_time = open_time;
		this.close_time = close_time;
		this.avg_delivery_time = avg_delivery_time;
		this.min_order_cost = min_order_cost;
		this.restaurant_image=restaurant_image;
		this.cuisines = cuisines;
	}

	public RestaurantDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public LocalTime getOpen_time() {
		return open_time;
	}

	public void setOpen_time(LocalTime open_time) {
		this.open_time = open_time;
	}

	public LocalTime getClose_time() {
		return close_time;
	}

	public void setClose_time(LocalTime close_time) {
		this.close_time = close_time;
	}

	public int getAvg_delivery_time() {
		return avg_delivery_time;
	}

	public void setAvg_delivery_time(int avg_delivery_time) {
		this.avg_delivery_time = avg_delivery_time;
	}

	public int getMin_order_cost() {
		return min_order_cost;
	}

	public void setMin_order_cost(int min_order_cost) {
		this.min_order_cost = min_order_cost;
	}

	public List<String> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<String> cuisines) {
		this.cuisines = cuisines;
	}

	public String getRestaurant_image() {
		return restaurant_image;
	}

	public void setRestaurant_image(String restaurant_image) {
		this.restaurant_image = restaurant_image;
	}
	
	
	
}

	