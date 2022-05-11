package com.sportyshoes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.api.dto.UserDto;
import com.sportyshoes.api.entities.Order;
import com.sportyshoes.api.entities.User;
import com.sportyshoes.api.services.OrderService;
import com.sportyshoes.api.services.UserService;

@RestController()
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;


	@PostMapping("/signUp")
	public User createUser(@RequestBody UserDto user) {
		return userService.createUser(user);
	}

	@PostMapping("/signIn")
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/search")
	public User getUserByName(@RequestParam String name) {
		return userService.getUserByName(name);
	}
	
	@PostMapping("/{userId}/product/{productId}/order")
	public Order placeOrder(@PathVariable Long userId,@PathVariable Long productId) {
		return orderService.placeOrder(userId, productId);
	}
	
	@GetMapping("/{userId}/order/all")
	public List<Order> viewOrderHistoryByUserId(@PathVariable Long userId) {
		return orderService.getAllOrderByUserId(userId);
	}
	
	@PatchMapping("/{userId}/update/password")
	public User updateUserPassword(@PathVariable(name="userId") Long userId, String password) {
		return userService.updateUserPassword(userId,password);
	}
	
	@PatchMapping("/{userId}/update/name")
	public User updateUserName(@PathVariable(name="userId") Long userId, String name) {
		return userService.updateUserName(userId,name);
	}

}
