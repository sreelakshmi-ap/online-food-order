package com.megaProject.OnlineFoodOrder.Response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class NearbyRestaurantsResponse {
	
	List<?> resultList;
	private HttpStatus responseStatus;
	private int noOfItems;
	private float rating;
	
	public NearbyRestaurantsResponse(List<?> resultList, HttpStatus responseStatus, int noOfItems, float rating) {
		this.resultList = resultList;
		this.responseStatus = responseStatus;
		this.noOfItems = noOfItems;
		this.rating = rating;
	}
	public List<?> getResultList() {
		return resultList;
	}
	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}
	public HttpStatus getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public NearbyRestaurantsResponse() {}

}
