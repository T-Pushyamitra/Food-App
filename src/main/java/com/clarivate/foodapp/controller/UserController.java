package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpStatus;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.services.UserServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/users")
	public ResponseStructure<List<User>> getAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);

	}

	@PutMapping("/users/{id}")
	public ResponseStructure<User> updateUser(@RequestBody User user,@PathVariable int id) {
		return userService.updateUser(user,id);
	}

}