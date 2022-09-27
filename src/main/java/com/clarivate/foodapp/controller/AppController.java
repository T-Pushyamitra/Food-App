package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpStatus;

import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.services.ItemService;
import com.clarivate.foodapp.services.UserServiceImpl;

@RestController
public class AppController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	ItemService itemService;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@PostMapping("/addUser")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "Deleted id" + id;
	}

	
	/** Item Controller */
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@PostMapping("/addItem")
	public Item saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

}
