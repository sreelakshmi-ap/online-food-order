package com.megaProject.OnlineFoodOrder.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.ReviewResponse;
import com.megaProject.OnlineFoodOrder.Services.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping(value="/addReview",consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE})
	public MessageResponse addReview(@RequestPart("review") String review , @RequestParam int restaurantId,@RequestPart(value = "file") MultipartFile file) throws IOException
	{
		return reviewService.addReview(review, restaurantId,file);
	}
	
	@GetMapping("/getReviews")
	public ListAndMessageResponse getReviews(@RequestParam Integer restaurantId)
	{
		List<ReviewResponse> response = reviewService.getReviewDetails(restaurantId);
		return new ListAndMessageResponse(response, HttpStatus.OK,response.size());
	}

}
