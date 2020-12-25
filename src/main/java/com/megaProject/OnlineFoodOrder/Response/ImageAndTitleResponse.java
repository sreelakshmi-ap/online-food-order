package com.megaProject.OnlineFoodOrder.Response;

public class ImageAndTitleResponse {
	
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_image_path() {
		return item_image_path;
	}
	public void setItem_image_path(String item_image_path) {
		this.item_image_path = item_image_path;
	}
	String item_name;
	String item_image_path;
	
	public ImageAndTitleResponse(String item_name, String item_image_path) {
		this.item_name = item_name;
		this.item_image_path = item_image_path;
	}
	
	public ImageAndTitleResponse() {}

}