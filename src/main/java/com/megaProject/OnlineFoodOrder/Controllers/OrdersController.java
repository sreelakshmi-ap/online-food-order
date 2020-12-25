package com.megaProject.OnlineFoodOrder.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Request.OrderRequest;
import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Response.OrderResponse;
import com.megaProject.OnlineFoodOrder.Services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders(@RequestParam Integer orderNumber) throws NoSuchElementException {
		List<OrderResponse> orderResponse = orderService.getOrderDetails(orderNumber);
		return ResponseEntity.ok(new ListAndMessageResponse(orderResponse, HttpStatus.OK, orderResponse.size()));
	}

	@PostMapping("/addOrder")
	public ResponseEntity<?> addAllOrders(@RequestBody OrderRequest orderRequest, @RequestParam Integer orderNumber)
			throws NoSuchElementException {
		orderService.addOrder(orderRequest, orderNumber);
		return ResponseEntity.ok(new MessageResponse("Order Added", HttpStatus.OK));
	}

	@PutMapping("/addOrderAgain")
	public ResponseEntity<?> addOrdersAgain(@RequestBody OrderRequest orderRequest, @RequestParam Integer orderNumber)
			throws NoSuchElementException {
		orderService.addOrderAgain(orderRequest, orderNumber);
		return ResponseEntity.ok(new MessageResponse("Order Added Again", HttpStatus.OK));
	}
	
	@PostMapping("/TotalAmount")
	public HashMap<String,Double> getTotalAmount(@RequestParam int orderNumber)
	{
		return orderService.getTotalForOrder(orderNumber);
	}
	
	@DeleteMapping("/clearCart")
	public MessageResponse clearCart(@RequestParam int orderNumber) {
		return orderService.clearCart(orderNumber);
		
		
	}
}
