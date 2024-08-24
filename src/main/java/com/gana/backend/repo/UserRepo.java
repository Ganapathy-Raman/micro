package com.gana.backend.repo;

import java.util.List;

import com.gana.backend.model.User;

public interface UserRepo {

	public User findByUserName(String userName);

	public User save(User user);
	
	public User findById(int userId);

	public List<User> findAll();

	public String update(User user);

	public String deleteById(int userId);
	

}
