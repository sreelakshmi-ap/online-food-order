package com.megaProject.OnlineFoodOrder.Response;

public class RatingResponse {

	int delivery_rating;

	String date_time;

	public RatingResponse() {
		super();
	}

	public RatingResponse(int delivery_rating, String date_time) {
		super();
		this.delivery_rating = delivery_rating;
		this.date_time = date_time;
	}

	public int getDelivery_rating() {
		return delivery_rating;
	}

	public void setDelivery_rating(int delivery_rating) {
		this.delivery_rating = delivery_rating;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

}