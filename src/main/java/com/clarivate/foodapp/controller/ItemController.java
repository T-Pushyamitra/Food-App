package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.services.ItemService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("/items/{id}")
	public ResponseStructure<Item> saveItem(@RequestBody Item item, @PathVariable int id) {
		return itemService.saveItem(item,id);
	}

	@GetMapping("/items")
	public ResponseStructure<List<Item>> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/getItems/{id}")
	public ResponseStructure<Item> getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}

	@DeleteMapping("/items/{id}")
	public ResponseStructure<String> deleteItem(@PathVariable int id) {
		return itemService.deleteItem(id);
	}

	@PutMapping("/items/{id}")
	public ResponseStructure<Item> updateItem(@RequestBody Item item,@PathVariable int id) {
		return itemService.updateItem(item,id);
	}
}