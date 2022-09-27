package com.clarivate.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.userRepository;

@Component
public class UserDao {

	@Autowired
	userRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
