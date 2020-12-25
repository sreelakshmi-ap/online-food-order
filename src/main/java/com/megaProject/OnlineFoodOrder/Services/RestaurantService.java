package com.megaProject.OnlineFoodOrder.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.Response.RatingResponse;
import com.megaProject.OnlineFoodOrder.models.Restaurants;
import com.megaProject.OnlineFoodOrder.repository.RestaurantsRepository;

@Service
public class RestaurantService {
	@Autowired
	RestaurantsRepository restaurantRepo;

	List<Restaurants> nearRestaurants;

	public List<Restaurants> getNearByRestaurants(double latitude, double longitude, String city, String cuisine) {
		double restaurantLat;
		double restaurantLong;
		double distance;
		Integer restaurant_id;

		List<Restaurants> cuisineRestaurantList = new ArrayList<>();
		List<Restaurants> nameList = new ArrayList<>();
		List<Restaurants> nearByRestaurantList = new ArrayList<>();
		List<Restaurants> searchRestaurantList = new ArrayList<>();
		List<Restaurants> restaurantList = new ArrayList<>();

		restaurantList = restaurantRepo.findByRestaurant_city(city);

		for (Restaurants restaurant : restaurantList) {
			restaurantLat = restaurant.getRestaurant_latitude();
			restaurantLong = restaurant.getRestaurant_longitude();

			distance = org.apache.lucene.util.SloppyMath.haversinMeters(latitude, longitude, restaurantLat,
					restaurantLong);

			if (distance <= 20000.0000) {
				nearByRestaurantList.add(restaurant);
			}
		}

		for (Restaurants restaurant : nearByRestaurantList) {
			restaurant_id = restaurant.getRestaurant_id();

			nameList = restaurantRepo.findByRestaurant_name(cuisine, restaurant_id);
			if (nameList.isEmpty()) {
				cuisineRestaurantList = restaurantRepo.findByCuisine(cuisine, restaurant_id);
				for (Restaurants cuisineRestaurant : cuisineRestaurantList) {
					if (!cuisineRestaurant.equals(null))
						searchRestaurantList.add(cuisineRestaurant);
				}
			} else
				searchRestaurantList = nameList;
		}
		nearRestaurants = searchRestaurantList;
		return searchRestaurantList;
	}

	public List<Restaurants> getFilteredRestaurants(int time, double minCost, double avgCost) {
		List<Restaurants> filtered = new ArrayList<>();
		for (Restaurants restaurant : nearRestaurants) {
			double avg_cost = restaurant.getAvg_order_cost();
			double min_cost = restaurant.getMin_order_cost();
			int avg_time = restaurant.getAvg_delivery_time();
			if ((avg_cost < avgCost) && (min_cost < minCost) && (avg_time < time)) {
				filtered.add(restaurant);
			}
		}
		return filtered;
	}

	public Restaurants getRestaurantById(int restaurantId) {
		return restaurantRepo.findRestaurantById(restaurantId);
	}

	public List<String> getCuiseneName(int restaurant_id) {
		List<String> cuisines = restaurantRepo.getCuisines(restaurant_id);
		return cuisines;
	}

	public float getRestaurantRating(int restaurantId) {
		String rating = restaurantRepo.getRestaurantRating(restaurantId);
		return Float.parseFloat(rating);

	}

	public List<RatingResponse> getAllRating(int restaurantId) {
		List<RatingResponse> ratingResponseList = new ArrayList<>();
		List<String> getallrating = restaurantRepo.getAllRatingByRestaurant(restaurantId);
		int rating;
		String dateTime;
		RatingResponse ratingResponse;
		for (String ratings : getallrating) {
			String[] ratingValue = ratings.split(",");
			rating = Integer.parseInt(ratingValue[0]);
//DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm:ss");
			dateTime = ratingValue[1];
			ratingResponse = new RatingResponse(rating, dateTime);
			ratingResponseList.add(ratingResponse);
		}
		return ratingResponseList;
	}


}