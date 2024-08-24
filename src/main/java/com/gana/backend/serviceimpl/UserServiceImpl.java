package com.gana.backend.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gana.backend.model.User;
import com.gana.backend.repo.UserRepo;
import com.gana.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User findByUserName(String username) {
		return userRepo.findByUserName(username);
	}

	@Override
	public User saveUser(User user) {
		user.setPassword((user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public User getUser(int userId) {

		return userRepo.findById(userId);

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();

	}

	@Override
	public String updateUser(User user) {
		return userRepo.update(user);

	}

	@Override
	public String deleteUser(int userId) {
		return userRepo.deleteById(userId);
	}

	@Override
	public User findById(int userId) {
		return userRepo.findById(userId);
	}

}
