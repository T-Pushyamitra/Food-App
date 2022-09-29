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
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.services.MenuService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MenuController {
	@Autowired
	MenuService menuService;

	@PostMapping("/menu/{id}")
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu, @PathVariable int id) {
		return menuService.saveMenu(menu,id);
	}

	@GetMapping("/menu")
	public ResponseStructure<List<Menu>> getAllMenus() {
		return menuService.getAllMenus();
	}
	
	@GetMapping("/menu/{id}")
	public ResponseStructure<Menu> getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}
	
	@DeleteMapping("/menu/{id}")
	public ResponseStructure<String> deleteMenu(@PathVariable int id) {
		return menuService.deleteMenu(id);
	}

	@PutMapping("/menu/{id}")
	public ResponseStructure<Menu> updateMenu(@RequestBody Menu menu,@PathVariable int id) {
		return menuService.updateMenu(menu,id);
	}
}
