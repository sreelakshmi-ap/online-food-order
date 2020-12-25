package com.megaProject.OnlineFoodOrder.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Helper.OTPGenerator;
import com.megaProject.OnlineFoodOrder.Request.MenuRequest;
import com.megaProject.OnlineFoodOrder.Response.ImageAndTitleResponse;
import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Response.MenuResponse;
import com.megaProject.OnlineFoodOrder.Response.SearchMenuResponse;
import com.megaProject.OnlineFoodOrder.Services.MenuService;
import com.megaProject.OnlineFoodOrder.models.Menu;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;

	@Autowired
	OTPGenerator generator;

	@GetMapping("/getMenu")
	public MenuResponse getMenuByRestaurant(@RequestParam int restaurant_id) {
		List<Menu> menuList = menuService.getAllMenu(restaurant_id);
		int order_number = Integer.parseInt(generator.generateRandomSpecialCharacters(7));
		return new MenuResponse(menuList, HttpStatus.OK, menuList.size(), order_number);
	}

	@GetMapping("/getSearchMenu")
	public SearchMenuResponse getSearchMenu(@RequestParam int restaurantId, String itemName) {
		Menu menu = menuService.getSearchItem(itemName,restaurantId);
		return new SearchMenuResponse(menu, HttpStatus.OK);
	}

	@GetMapping("/getItemNameAndItemImage")
	public ListAndMessageResponse ItemNameAndItemImage(@RequestParam int restaurant_id) {
		List<ImageAndTitleResponse> imageAndTitleList = menuService.getItemNameAndItemImage(restaurant_id);
		return new ListAndMessageResponse(imageAndTitleList, HttpStatus.OK, imageAndTitleList.size());
	}
}
