package com.megaProject.OnlineFoodOrder.Controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Request.CurrentLocationRequest;
import com.megaProject.OnlineFoodOrder.Request.FilterRequest;
import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Response.RatingResponse;
import com.megaProject.OnlineFoodOrder.Response.RestaurantAndRatingResponse;
import com.megaProject.OnlineFoodOrder.Response.RestaurantDetailsResponse;
import com.megaProject.OnlineFoodOrder.Services.RestaurantService;
import com.megaProject.OnlineFoodOrder.models.Restaurants;
import com.megaProject.OnlineFoodOrder.repository.RestaurantsRepository;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	RestaurantsRepository restaurantRepo;

	@GetMapping("/getNearByRestaurants")
	public ResponseEntity<?> getNearByRestaurants(@RequestParam double latitude, double longitude, String SearchBy, String City) {
		double currentLat = latitude;
		double currentLong = longitude;
		String city = City;
		String searchBy =SearchBy;
		float rating;
		List<String> cuisines = new ArrayList<>();
		List<Restaurants> nearByRestaurants = restaurantService.getNearByRestaurants(currentLat, currentLong, city,
				searchBy);
		List<RestaurantAndRatingResponse> response = new ArrayList<>();
		RestaurantAndRatingResponse restaurantAndRating;
		for(Restaurants restaurant: nearByRestaurants)
		{
			rating = restaurantService.getRestaurantRating(restaurant.getRestaurant_id());
			cuisines = restaurantService.getCuiseneName(restaurant.getRestaurant_id());
			restaurantAndRating = new RestaurantAndRatingResponse(restaurant, rating, cuisines);
			response.add(restaurantAndRating);
		}
		return ResponseEntity.ok(new ListAndMessageResponse(response,HttpStatus.OK, response.size()));
	}
	
	@GetMapping("/getFilteredRestaurants")
	public ResponseEntity<?> getFilteredRestaurants(int Time, double minimumCost, double avgCost) {
		double averageCost =avgCost ;
		double minCost = minimumCost;
		int time =Time ;
		float rating;
		List<String> cuisines = new ArrayList<>();
		List<RestaurantAndRatingResponse> response = new ArrayList<>();
		RestaurantAndRatingResponse restaurantAndRating;
		List<Restaurants> filtered =restaurantService.getFilteredRestaurants(time,averageCost,minCost);
		for(Restaurants restaurant: filtered)
		{
			rating=restaurantService.getRestaurantRating(restaurant.getRestaurant_id());
			cuisines = restaurantService.getCuiseneName(restaurant.getRestaurant_id());
			restaurantAndRating = new RestaurantAndRatingResponse(restaurant, rating, cuisines);
			response.add(restaurantAndRating);
		}
		return ResponseEntity.ok(new ListAndMessageResponse(response,HttpStatus.OK, response.size()));
	}
	
	@GetMapping("/getBrandRestaurantsByCity")
	public ResponseEntity<?> getBrandRestaurantsByCity(@RequestParam int brandId,String City) {
		String city =City;
		List<Restaurants> brandedRestaurants = restaurantRepo.findByBrandsRestaurantByCity(brandId, city);
		return ResponseEntity
				.ok(new ListAndMessageResponse(brandedRestaurants, HttpStatus.OK, brandedRestaurants.size()));
	}

	@GetMapping("/getRestaurantById")
	public RestaurantDetailsResponse getNearByRestaurants(@RequestParam int restaurantId) {
		Restaurants restaurant = restaurantService.getRestaurantById(restaurantId);
		List<String> cuisines = restaurantService.getCuiseneName(restaurantId);
		String name = restaurant.getRestaurant_name();
		LocalTime open_time = restaurant.getOpen_time();
		LocalTime close_time = restaurant.getClose_time();
		Integer avg_delivery_time = restaurant.getAvg_delivery_time();
		int cost = restaurant.getMin_order_cost();
		String restaurant_image = restaurant.getRestaurant_image();

		return new RestaurantDetailsResponse(name, open_time, close_time, avg_delivery_time, cost, restaurant_image,
				cuisines);
	}
	
	
	@GetMapping("/getAllRating")
	public ResponseEntity<?> getAllRating(@RequestParam int restaurantId)
	{
		List<RatingResponse> ratingResponses = restaurantService.getAllRating(restaurantId);
		return ResponseEntity.ok(new ListAndMessageResponse(ratingResponses,HttpStatus.OK, ratingResponses.size()));
	}

}
