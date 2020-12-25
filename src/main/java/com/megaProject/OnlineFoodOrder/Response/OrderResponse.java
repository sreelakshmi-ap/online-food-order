package com.megaProject.OnlineFoodOrder.Response;

public class OrderResponse {
	private String order_number;
	private String item_name;
	private String price;
	private String menu_price;

	public OrderResponse(String order_number, String item_name, String price, String menu_price) {
		super();
		this.order_number = order_number;
		this.item_name = item_name;
		this.price = price;
		this.menu_price = menu_price;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}

}