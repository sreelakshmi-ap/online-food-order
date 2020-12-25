package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megaProject.OnlineFoodOrder.models.Review;

public interface ReviewRepository extends JpaRepository<Review ,Integer> {
	
	@Query(value = "select u.first_name, u.last_name, r.likes, r.review_description, r.food_rating, r.service_rating,r.review_date, u.user_id\r\n"
			+ "from users u, reviews r\r\n"
			+ "where u.user_id in (select user_id from reviews where restaurant_id = ?1)\r\n"
			+ "and r.restaurant_id = ?1\r\n"
			+ "and u.user_id = r.user_id",nativeQuery = true)
	public List<String> getReviewDetails(int restaurantId);
	
	
	@Query(value ="select count(review_description), count(food_rating), r.food_image , u.image_path from reviews r, users u\r\n"
			+ "where u.user_id in (select user_id from reviews where user_id = ?1 and restaurant_id =?2)\r\n"
			+ "and r.user_id = ?1 and r.restaurant_id = ?2", nativeQuery = true)
	public List<String> getReviewCount(int user_id, int restaurant_id);

}