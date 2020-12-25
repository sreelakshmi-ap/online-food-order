package com.megaProject.OnlineFoodOrder.Response;

public class getOrderResponse {
	
	long order_number;
	String restaurant_address;
	String restaurant_name;
	int item_number;
	double amount;
	String status;
	public getOrderResponse(long order_number, String restaurant_address, String restaurant_name, int item_number,
			double amount, String status) {
		super();
		this.order_number = order_number;
		this.restaurant_address = restaurant_address;
		this.restaurant_name = restaurant_name;
		this.item_number = item_number;
		this.amount = amount;
		this.status = status;
	}
	public getOrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public getOrderResponse(int item_number) {
		super();
		this.item_number = item_number;
	}
	public long getOrder_number() {
		return order_number;
	}
	public void setOrder_number(long order_number) {
		this.order_number = order_number;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public int getItem_number() {
		return item_number;
	}
	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
