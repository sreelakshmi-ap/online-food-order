package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megaProject.OnlineFoodOrder.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query(value = "select * from menu\r\n"
			+ "where menu_id in(select menu_id from restaurant_menu_mapping where restaurant_id = ?)", nativeQuery = true)
	public List<Menu> getMenuForRestaurant(int id);

	@Query(value = "select m.* from menu m,restaurant_menu_mapping r where m.item_name=?1 and m.menu_id=r.menu_id and r.restaurant_id=?2", nativeQuery = true)
	Menu getSearchItem(String itemName, int restaurantId);

	@Query(value = "select menu.item_name,menu.item_image_path from megaproject.menu where menu.menu_id in(select restaurant_menu_mapping.menu_id from megaproject.restaurant_menu_mapping\r\n"
			+ "where restaurant_menu_mapping.restaurant_id=?)", nativeQuery = true)
	public List<String> getItemNameAndImagePathForMenu(int restaurant_id);

}
