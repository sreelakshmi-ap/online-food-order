package com.megaProject.OnlineFoodOrder.Request;

public class MenuRequest {
	
	private int restaurantId;
	private String itemName;
	
	public MenuRequest(int restaurantId, String itemName) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	

}
