package com.gana.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gana.backend.model.User;
import com.gana.backend.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class UserController {

	UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/register")
	public String register(@RequestBody User user) {
		User existingUser = userService.findByUserName(user.getUserName());
		if (existingUser != null) {
			return "username already exists";
		}
		userService.saveUser(user);
		return "User registered successfully";
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User existingUser = userService.findByUserName(user.getUserName());
		if (existingUser != null && user.getPassword().equals(existingUser.getPassword())) {
			return existingUser;
		} else {
			return null;
		}
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}

	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@PutMapping
	public String updateUser(@RequestBody User user) {

		String msg = "";
		try {
			userService.updateUser(user);
			msg = "Good";
		} catch (Exception e) {

			msg = "Bad";

		}
		return msg;
	}

	@DeleteMapping("{userId}")
	public String deleteUserById(@PathVariable("userId") int userId) {
		String msg = "";
		try {
			userService.deleteUser(userId);
			msg = "Fair";
		} catch (Exception e) {

			msg = "Not";

		}
		return msg;
	}

}
