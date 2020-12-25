package com.megaProject.OnlineFoodOrder.Response;

import org.springframework.http.HttpStatus;

import com.megaProject.OnlineFoodOrder.models.Menu;

public class SearchMenuResponse {

	private Menu menu;
	private HttpStatus responseStatus;

	public SearchMenuResponse(Menu menu, HttpStatus responseStatus) {
		super();
		this.menu = menu;
		this.responseStatus = responseStatus;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public HttpStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(HttpStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

}
