package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.megaProject.OnlineFoodOrder.models.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

	@Query(value = "select * from order_details where order_number = ?", nativeQuery = true)
	List<OrderDetails> findDetailsByOrderNumber(Integer order_number);
	
	@Query(value ="SELECT * FROM megaproject.order_details where menu_id=?1 and order_number=?2",nativeQuery = true)
	OrderDetails findMapId(Integer menu_id,Integer order_number);

	@Modifying
	@Transactional
	@Query(value = "UPDATE megaproject.order_details SET quantity =?1,menu_price=?2 WHERE map_id=?3",nativeQuery = true)
	void findByOrderNumberAndMenu(Integer quantity,double menu_price,Integer map_id);
	
	@Modifying
	@Transactional
	@Query(value = "Delete from order_details where order_number = ?",nativeQuery = true)
	void deleteCart(int order_number);
}

