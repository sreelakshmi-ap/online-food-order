package com.megaProject.OnlineFoodOrder.Request;

public class OrderRequest {

	private int restaurantId;
	private int menuId;
	private double price;
	private int quantity;

	public OrderRequest(int restaurantId, int menuId, double price, int quantity) {
		this.restaurantId = restaurantId;
		this.menuId = menuId;
		this.price = price;
		this.quantity = quantity;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}