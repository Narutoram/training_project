package com.sportyshoes.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.api.entities.User;
import com.sportyshoes.api.services.UserService;

@RestController()
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signIn")
	public User loginUser(@RequestBody User user) {
		return userService.loginUser(user);
	}

	@PatchMapping("/{adminId}/update/password")
	public User updateAdminPassword(@PathVariable(name="adminId") Long adminId, String password) {
		return userService.updateAdminPassword(adminId,password);
	}
	
	

}
