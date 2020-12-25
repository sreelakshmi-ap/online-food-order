package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megaProject.OnlineFoodOrder.models.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {
	@Query(value = "SELECT * FROM megaproject.restaurants where restaurant_city = ?", nativeQuery = true)
	List<Restaurants> findByRestaurant_city(String city);

	@Query(value = "select * from megaproject.restaurants\r\n"
			+ "where restaurant_id in ( Select restaurant_id from restaurant_cuisine_mapping where cuisine_name = ?1 and restaurant_id = ?2 )", nativeQuery = true)
	List<Restaurants> findByCuisine(String cuisine, Integer r_id);

	@Query(value = "SELECT * FROM megaproject.restaurants where restaurant_name = ?1 and restaurant_id = ?2", nativeQuery = true)
	List<Restaurants> findByRestaurant_name(String name, Integer r_id);

	@Query(value = "Select * from megaproject.restaurants where restaurant_id in(select restaurant_id from megaproject.brand_city_mapping where brand_id=?1 and city=?2)", nativeQuery = true)
	List<Restaurants> findByBrandsRestaurantByCity(int brandsId, String city);

	@Query(value = "select * from megaproject.restaurants where restaurant_id=?", nativeQuery = true)
	Restaurants findRestaurantById(int restaurantId);
	
	@Query(value = "select cuisine_name from megaproject.restaurant_cuisine_mapping where restaurant_id=?", nativeQuery = true)
	List<String> getCuisines(int restaurant_id);
	
	@Query(value = "select item_image_path from menu where menu_id in\r\n" + 
			"(select menu_id from restaurant_menu_mapping where restaurant_id = ?)", nativeQuery = true)
	List<String> nearByRestaurantMenuImage(int restaurantId);
	
	@Query(value = "select avg(food_rating) from reviews where restaurant_id = ?", nativeQuery = true)
	String getRestaurantRating(int restaurantId);
	
	@Query(value = "select delivery_rating,date_time from megaproject.orders where restaurant_id=?", nativeQuery = true)
	List<String> getAllRatingByRestaurant(int restaurantId);
	
}
