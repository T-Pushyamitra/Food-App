package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.services.MenuService;

@RestController
public class MenuController {
	@Autowired
	MenuService menuService;

	@PostMapping("/menu")
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}

	@GetMapping("/menu")
	public ResponseStructure<List<Menu>> getAllMenus() {
		return menuService.getAllMenus();
	}
}
