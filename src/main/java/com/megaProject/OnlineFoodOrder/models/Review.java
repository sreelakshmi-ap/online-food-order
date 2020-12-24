package com.megaProject.OnlineFoodOrder.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int review_id;

	@Column
	int user_id;

	@Column
	int food_rating;

	@Column
	int service_rating;

	@Column(name = "food_image")
	String image_path;

	@Column(name = "review_description")
	String review;

	@Column
	int likes;

	@Column
	int restaurant_id;

	@Column
	LocalDate review_date;

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public LocalDate getReview_date() {
		return review_date;
	}

	public void setReview_date(LocalDate review_date) {
		this.review_date = review_date;
	}

	public Review(int food_rating, int service_rating, String review, LocalDate date, int user_id, int restaurantId) {
		super();
		this.food_rating = food_rating;
		this.service_rating = service_rating;
		this.review = review;
		this.review_date = date;
		this.user_id = user_id;
		this.restaurant_id = restaurantId;
	}

	public Review(int user_id, int food_rating, int service_rating, String image_path, String review,
			LocalDate review_date) {
		this.user_id = user_id;
		this.food_rating = food_rating;
		this.service_rating = service_rating;
		this.image_path = image_path;
		this.review = review;
		this.review_date = review_date;
	}

	public Review() {
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
