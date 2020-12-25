package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megaProject.OnlineFoodOrder.models.OrderDetails;
import com.megaProject.OnlineFoodOrder.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query(value = "select m.item_name,od.price, od.menu_price,ord.order_number from menu m,order_details od ,orders ord where \r\n"
			+ "m.menu_id in (select menu_id from order_details where order_number=?1) and \r\n"
			+ "od.order_number=?1 and ord.order_number=?1 and m.menu_id=od.menu_id", nativeQuery = true)
	List<String> getOrderDetails(Integer orderNumber);

	@Query(value = "SELECT * FROM orders WHERE order_number =?1", nativeQuery = true)
	List<Orders> findByOrderNumber(Integer orderNumber);
	
	@Query(value = "select cost from restaurant_menu_mapping where restaurant_id = ?1 and menu_id =?2", nativeQuery = true)
	String getPriceFromMapping(int restaurantId, int menu_id);                                
	

}