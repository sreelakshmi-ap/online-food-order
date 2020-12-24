package com.megaProject.OnlineFoodOrder.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.ReviewResponse;
import com.megaProject.OnlineFoodOrder.models.Review;
import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.ReviewRepository;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UploadService uploadService;
	
	public MessageResponse addReview(String Review, Integer restaurantId,MultipartFile file) throws IOException
	{
		Authentication authentication=(Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int user_id = currentUser.getUser_id();
		Review review = new Review();
		
		try {
			ObjectMapper objectmapper=new ObjectMapper();;
			review = objectmapper.readValue(Review,Review.class);
		}catch(IOException err) {
			System.out.println(err);
		}
			
		   // review.setFood_rating(review.getFood_rating());
		   // review.setReview(review.getReview());
		   // review.setService_rating(review.getService_rating());
		   // review.setReview_date(review.getReview_date());
		    review.setUser_id(user_id);
		    String fileUrl= this.uploadService.uploadFile(file);
		    review.setImage_path(fileUrl);
		    review.setRestaurant_id(restaurantId);
		
		
		reviewRepo.save(review);
		
		return new MessageResponse("Review added",HttpStatus.CREATED );
		 
	}
	
	public List<ReviewResponse> getReviewDetails(Integer restaurantId) {
		List<ReviewResponse> orderResponseList = new ArrayList<>();
		List<String> reviewsList = reviewRepo.getReviewDetails(restaurantId);
		String first_name, last_name, review_description, date, user_image, food_image;
		float rating;
		int food_rating, service_rating,likes, user_id, reviewCount, ratingCount;
		List<String> reviewAndRatingCount;
		ReviewResponse response;
		for (String order : reviewsList) {
			String[] orderValues = order.split(",");
			first_name = orderValues[0];
			last_name = orderValues[1];
			likes = Integer.parseInt(orderValues[2].toString());
			review_description = orderValues[3].toString();
			food_rating = Integer.parseInt(orderValues[4]);
			service_rating = Integer.parseInt(orderValues[5]);
			rating = ((food_rating + service_rating)/2);
			date = orderValues[6].toString();
			user_id = Integer.parseInt(orderValues[7]);
			reviewAndRatingCount = reviewRepo.getReviewCount(user_id, restaurantId);
			
			response = new ReviewResponse(first_name, last_name, review_description, likes, rating, date);
			
			for (String count : reviewAndRatingCount) {
				String[] countValues = count.split(",");
				reviewCount = Integer.parseInt(countValues[0]);
				ratingCount = Integer.parseInt(countValues[1]);
				food_image = countValues[2];
				user_image = countValues[3];
				response.setReviewCount(reviewCount);
				response.setRatingCount(ratingCount);
				response.setFood_image(food_image);
				response.setUser_image(user_image);
			}
			orderResponseList.add(response);
		}
		return orderResponseList;
	}
	
	
	
	
}
