 package com.megaProject.OnlineFoodOrder.Services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.Request.OrderRequest;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.OrderResponse;
import com.megaProject.OnlineFoodOrder.models.OrderDetails;
import com.megaProject.OnlineFoodOrder.models.Orders;
import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.OrderDetailsRepo;
import com.megaProject.OnlineFoodOrder.repository.OrdersRepository;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;
import java.util.HashMap;

@Service
public class OrderService {

	@Autowired
	OrdersRepository orderRepo;

	@Autowired
	OrderDetailsRepo orderDetailsRepo;
	
	@Autowired
	UserRepository userRepo;

	OrderDetails orderDetails = new OrderDetails();
	
	double sum = 0;

public void addOrder(OrderRequest orderRequest, Integer orderNumber) {
		
		Authentication authentication=(Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int user_id = currentUser.getUser_id();
		
		Orders order = new Orders();
		OrderDetails orderDetails = new OrderDetails();
		String price = orderRepo.getPriceFromMapping(orderRequest.getRestaurantId(), orderRequest.getMenuId());
		double priceInt = Integer.parseInt(price);

		if (orderRepo.findByOrderNumber(orderNumber).isEmpty()) {
			order.setOrder_number(orderNumber);
			order.setUser_id(user_id);
			order.setRestaurant_id(orderRequest.getRestaurantId());
			orderRepo.save(order);
			orderDetails.setMenu_id(orderRequest.getMenuId());
			orderDetails.setPrice(priceInt);
			orderDetails.setQuantity(orderRequest.getQuantity());
			orderDetails.setMenu_price(priceInt * orderRequest.getQuantity());
			orderDetails.setOrder_number(orderNumber);
			orderDetailsRepo.save(orderDetails);
		} else  {
			orderDetails.setMenu_id(orderRequest.getMenuId());
			orderDetails.setPrice(priceInt);
			orderDetails.setQuantity(orderRequest.getQuantity());
			orderDetails.setMenu_price(priceInt * orderRequest.getQuantity());
			orderDetails.setOrder_number(orderNumber);
			orderDetailsRepo.save(orderDetails);
		}
	}
	
	public void addOrderAgain(OrderRequest orderRequest, Integer orderNumber) {
		Integer menu_id = orderRequest.getMenuId();
		
		String price = orderRepo.getPriceFromMapping(orderRequest.getRestaurantId(), orderRequest.getMenuId());
		double priceInt = Integer.parseInt(price);
		double menu_price = priceInt * orderRequest.getQuantity();
		OrderDetails order = orderDetailsRepo.findMapId(menu_id, orderNumber);
		System.out.println(order.getMap_id());
		orderDetailsRepo.findByOrderNumberAndMenu(orderRequest.getQuantity(), menu_price, order.getMap_id());
	}

	@Autowired
	private OrdersRepository ordersRepository;

	public List<OrderResponse> getOrderDetails(Integer orderNumber) {
		List<OrderResponse> orderResponseList = new ArrayList<>();
		List<String> ordersList = ordersRepository.getOrderDetails(orderNumber);
		String item_name, price, menu_price, order_number;
		OrderResponse response;
		for (String order : ordersList) {
			String[] orderValues = order.split(",");
			item_name = orderValues[0];
			price = orderValues[1];
			menu_price = orderValues[2].toString();
			order_number = orderValues[3].toString();
			response = new OrderResponse(order_number, item_name, price, menu_price);
			orderResponseList.add(response);
		}
		return orderResponseList;
	}
	
	public HashMap<String,Double> getTotalForOrder(Integer orderNumber)
	{
		HashMap<String,Double> totalAmount = new HashMap<String,Double>();
		List<OrderDetails> detailsList = new ArrayList<>();
		detailsList = orderDetailsRepo.findDetailsByOrderNumber(orderNumber);
		
		double sum = 0;
		for(OrderDetails detail : detailsList)
		{
			sum += detail.getMenu_price();
		
		}
		Orders order=orderRepo.findByOrderNumber(orderNumber).get(0);
		order.setAmount(sum);
		orderRepo.save(order);
		totalAmount.put("To Pay",sum);
		return totalAmount;
		
	}
	
	public MessageResponse clearCart(int order_number) {
		orderDetailsRepo.deleteCart(order_number);
		return new MessageResponse("cart cleared Successfully!",HttpStatus.OK);
		
	}
}