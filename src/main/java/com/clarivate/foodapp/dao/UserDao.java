package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.userRepository;

@Component
public class UserDao {
	
	private static final Optional<User> User = null;

	@Autowired
	userRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUsers(int id) {
		userRepository.deleteById(id);
	}

	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

}