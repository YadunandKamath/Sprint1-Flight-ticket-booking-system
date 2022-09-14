package com.capg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IUserDao;
import com.capg.entities.User;
import com.capg.exceptions.UserAlreadyExistsException;
import com.capg.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDao userDao;
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		return userDao.findById(userId).get();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.existsById(user.getUserId())) {
			throw new UserAlreadyExistsException();
		}
		userDao.save(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if(userDao.findById(user.getUserId()).isEmpty()) {
			throw new UserNotFoundException();
		}
		userDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		if(userDao.findById(userId).isEmpty()) {
			throw new UserNotFoundException();
		}
		User u = userDao.getOne(userId);
		userDao.delete(u);
	}
	
	/*
	List<User> user_list;
	
	public UserServiceImpl() {
		user_list=new ArrayList<>();
		user_list.add(new User(001, "personA", "lastA", "A@gmail.com", "##44", "9156666666"));
		user_list.add(new User(002, "personB", "lastB", "B@gmail.com", "##445", "9156666667"));
		user_list.add(new User(003, "personC", "lastC", "C@gmail.com", "##446", "9156666668"));
	}

	@Override
	public List<User> getUsers() {
		
		return user_list;
	}

	@Override
	public User getUser(int userId) {
		
		User u =null;
		for(User user:user_list) {
			if(user.getUserId()==userId) {
				u=user;
				break;
			}
		}
		
		return u;
	}

	@Override
	public User addUser(User user) {
		user_list.add(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		
		user_list.forEach(e->{
			if(e.getUserId()==user.getUserId()) {
				e.setFirstName(user.getFirstName());
				e.setLastName(user.getLastName());
				e.setEmail(user.getEmail());
				e.setPassword(user.getPassword());
				e.setContactNo(user.getContactNo());
			}
		});
		
		return user;
	}

	@Override
	public void deleteUser(int userId) {
		user_list=this.user_list.stream().filter(e->(e.getUserId()!=userId)).collect(Collectors.toList());
		
	}
	*/
}
