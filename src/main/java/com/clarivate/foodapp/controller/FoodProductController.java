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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.repository.FoodProductRepository;
import com.clarivate.foodapp.services.FoodProductService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/menu")
public class FoodProductController {
	
	
	
	@Autowired
	FoodProductService foodProductService;

	@PostMapping("/foodProducts/{id}")
	public ResponseStructure<List<FoodProducts>> saveAllFoodProducts(@RequestBody List<FoodProducts> foodProduct,@PathVariable int id) {
		return foodProductService.saveAllFoodProducts(foodProduct,id);
	}
	@GetMapping("/foodProducts")
	public ResponseStructure<List<FoodProducts>> getAllFoodProduct() {
		return foodProductService.getAllFoodProducts();
	}
	
	@GetMapping("/foodProducts/menu/{id}")
	public ResponseStructure<List<FoodProducts>> getFoodProductsByMenuId(@PathVariable int id) {
		return foodProductService.getFoodProductsByMenuId(id);
	}
	
	@GetMapping("/foodProducts/{id}")
	public ResponseStructure<FoodProducts> getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductsById(id);
	}

	@GetMapping("/foodProducts/name/{name}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByNameContaining(@PathVariable String name) {
		return foodProductService.getFoodProductsByNameContaining(name);
	}
	
	@GetMapping("/foodProducts/type/{type}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByType(@PathVariable String type) {
		return foodProductService.getFoodProductsByType(type);
	}
	
	@GetMapping("/foodProducts/availability/{availability}")
	public ResponseStructure<List<FoodProducts>> getFoodProductByAvailability(@PathVariable boolean availability) {
		return foodProductService.getFoodProductsByAvailability(availability);
	}
	
	
	@DeleteMapping("/foodProducts/delete/{id}")
	public ResponseStructure<String> deleteFoodProduct(@PathVariable int id) {
		return foodProductService.deleteFoodProducts(id);
	}

	@DeleteMapping("/foodProducts/deleteAll/{id}")
	public ResponseStructure<String> deleteAllFoodProductsByMenuId(@PathVariable int id) {
		return foodProductService.deleteFoodProductsByMenuId(id);
	}
	@PutMapping("/foodProducts/update/{id}")
	public ResponseStructure<FoodProducts> updateFoodProducts(@RequestBody FoodProducts foodProduct,@PathVariable int id) {
		return foodProductService.updateFoodProducts(foodProduct,id);
	}
}
