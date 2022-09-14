package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entities.User;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.exceptions.UserNotFoundException;
import com.capg.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/home")
	public String Home() {
		return "Welcome to user application of flight booking system";
	}

	//get data of all the users	
	@GetMapping("/users")
	public List<User> getUsers(){	
		return this.userService.getUsers();	
	}
	
	//get user having specific userid
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) throws UserNotFoundException{
		return this.userService.getUser(userId);
	}
	
	//add a new user into user dataset
	@PostMapping("/users")
	public User addUser(@RequestBody User user) throws UserAlreadyExistsException{
		return this.userService.addUser(user);
	}
	
	//update user using userid
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) throws UserNotFoundException{
		return this.userService.updateUser(user);
	}
	
	//delete the user
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable int userId)throws UserNotFoundException{
		try {
			this.userService.deleteUser(userId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
