package com.clarivate.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.userRepository;

@Repository
public class UserDao {

	
	@Autowired
	userRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	

}
