package com.sportyshoes.api.services;

import java.util.List;

import com.sportyshoes.api.dto.UserDto;
import com.sportyshoes.api.entities.User;
public interface UserService {

	public User createUser(UserDto user);

	public User loginUser(User user);

	public User getUserById(Long userId);

	public List<User>  getAllUsers();

	public User getUserByName(String userName);

	public User updateAdminPassword(Long adminId, String password);

	public User updateUserPassword(Long userId, String password);

	public User updateUserName(Long userId, String name);

}
