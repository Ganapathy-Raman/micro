package com.gana.backend.service;

import java.util.List;

import com.gana.backend.model.User;

public interface UserService {

	public User findByUserName(String userName);

	public User saveUser(User user);
	
	public User getUser(int userId);

	public List<User> getAllUsers();

	public String updateUser(User user);

	public String deleteUser(int userId);
	
	public User findById(int userId);

}
