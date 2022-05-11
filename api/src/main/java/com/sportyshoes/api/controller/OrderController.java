package com.sportyshoes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.api.entities.Order;
import com.sportyshoes.api.services.OrderService;

@RestController()
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/all/sorted")
	public List<Order> sortOrder(@RequestParam(name="key") String key,@RequestParam(name="ordering") String ordering) {
		return orderService.sortOrder(key,ordering);
	}

	  @GetMapping("all/{userId}") public List<Order>
	  getAllOrderByUserId(@PathVariable Long userId) { return
	  orderService.getAllOrderByUserId(userId); }
	  
	  @GetMapping("all/{productId}") public List<Order>
	  getAllOrderByProductId(@PathVariable Long productId) { return
	  orderService.getAllOrderByProductId(productId); }
	 
	

}
