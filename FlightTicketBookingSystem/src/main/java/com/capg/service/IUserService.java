package com.capg.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capg.entities.User;


public interface IUserService {
	public List<User> getUsers();
	
	public User getUser(int userId);
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(int userId);
}
