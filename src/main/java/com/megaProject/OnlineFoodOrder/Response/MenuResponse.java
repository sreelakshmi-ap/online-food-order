package com.megaProject.OnlineFoodOrder.Response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class MenuResponse {
	List<?> resultList;
	private HttpStatus responseStatus;
	private int noOfItems;
	private int order_num;

	public MenuResponse() {
	}

	public MenuResponse(List<?> resultList, HttpStatus responseStatus, int noOfItems, int order_num) {
		this.resultList = resultList;
		this.responseStatus = responseStatus;
		this.noOfItems = noOfItems;
		this.order_num = order_num;
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

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

}
