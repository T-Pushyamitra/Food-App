package com.clarivate.foodapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.User;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user) {
		return userDao.addUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	public void delete(int id) {
		userDao.deleteUsers(id);
	}

}
