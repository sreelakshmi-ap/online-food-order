package com.megaProject.OnlineFoodOrder.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.Response.ImageAndTitleResponse;
import com.megaProject.OnlineFoodOrder.models.Menu;
import com.megaProject.OnlineFoodOrder.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	MenuRepository menuRepo;

	public List<Menu> getAllMenu(int restaurant_id) {
		return menuRepo.getMenuForRestaurant(restaurant_id);

	}

	public Menu getSearchItem(String itemName, int restaurantId) {
		return menuRepo.getSearchItem(itemName, restaurantId);
	}
	
	public List<ImageAndTitleResponse> getItemNameAndItemImage(int restaurant_id){
		List<ImageAndTitleResponse> imageAndTitleList = new ArrayList<>();
		List<String> ItemandImage = menuRepo.getItemNameAndImagePathForMenu(restaurant_id);
		String item_name,item_image_path;
		ImageAndTitleResponse response;
		for(String item:ItemandImage) {
			String[] itemValues = item.split(",");
			item_name = itemValues[0];
			item_image_path= itemValues[1];
			response = new ImageAndTitleResponse(item_name,item_image_path);
			imageAndTitleList.add(response);
		}
		return imageAndTitleList;
		
	}
}
