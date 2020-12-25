package com.megaProject.OnlineFoodOrder.Response;

public class ReviewResponse {
	String first_name;
	String last_name;
	String description;
	int likes;
	String date;
	float rating;
	int ratingCount;
	int reviewCount;
	String user_image;
	String food_image;
	
	public String getUser_image() {
		return user_image;
	}


	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}


	public String getFood_image() {
		return food_image;
	}


	public void setFood_image(String food_image) {
		this.food_image = food_image;
	}


	public int getRatingCount() {
		return ratingCount;
	}


	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}


	public int getReviewCount() {
		return reviewCount;
	}


	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}


	public ReviewResponse(String first_name, String last_name, String description, int likes, float rating, String date) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.description = description;
		this.likes = likes;
		this.rating = rating;
		this.date = date;
	}
	

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public ReviewResponse() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}


	public ReviewResponse(String first_name, String last_name, String description, int likes, String date, float rating,
			int ratingCount, int reviewCount) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.description = description;
		this.likes = likes;
		this.date = date;
		this.rating = rating;
		this.ratingCount = ratingCount;
		this.reviewCount = reviewCount;
	}
	

}
