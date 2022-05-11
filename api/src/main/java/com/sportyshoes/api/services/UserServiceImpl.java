package com.sportyshoes.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportyshoes.api.dao.UserDao;
import com.sportyshoes.api.dto.UserDto;
import com.sportyshoes.api.entities.User;
import com.sportyshoes.api.exception.SportyshoesNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User createUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setRole("USER");
		return userDao.save(user);
	}

	@Override
	public User loginUser(User user) {
		User result = userDao.findByNameAndPassword(user.getName(), user.getPassword()).orElse(null);
		if (result == null) {
			throw new SportyshoesNotFoundException(
					"User name: " + user.getName() + " doesn't exist / Invalid Credentials");
		} else {
			return user;
		}
	}

	@Override
	public User getUserById(Long userId) {
		return userDao.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUserByName(String userName) {
		return userDao.findByName(userName).get();
	}

	@Override
	public User updateAdminPassword(Long adminId, String password) {
		User result = userDao.findById(adminId).orElse(null);
		if (result == null) {
			throw new SportyshoesNotFoundException("Admin Id: " + adminId + " doesn't exist");
		} else if (!result.getRole().equalsIgnoreCase("ADMIN")) {
			throw new SportyshoesNotFoundException("This is not an admin Account");
		}
		result.setPassword(password);
		return userDao.save(result);
	}

	@Override
	public User updateUserPassword(Long userId, String password) {
		User result = userDao.findById(userId).orElse(null);
		if (result == null) {
			throw new SportyshoesNotFoundException("User Id: " + userId + " doesn't exist");
		}
		result.setPassword(password);
		return userDao.save(result);
	}

	@Override
	public User updateUserName(Long userId, String name) {
		User result = userDao.findById(userId).orElse(null);
		if (result == null) {
			throw new SportyshoesNotFoundException("user Id: " + userId + " doesn't exist");
		}
		result.setName(name);
		return userDao.save(result);
	}

}
