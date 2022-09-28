package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.services.FoodProductService;

@RestController
public class FoodProductController {

	@Autowired
	FoodProductService foodProductService;

	@PostMapping("/foodProduct/{id}")
	public ResponseStructure<FoodProducts> saveFoodProducts(@RequestBody FoodProducts foodProduct,@PathVariable int id) {
		return foodProductService.saveFoodProducts(foodProduct,id);
	}
	@GetMapping("/foodProduct")
	public ResponseStructure<List<FoodProducts>> getAllFoodProduct() {
		return foodProductService.getAllFoodProducts();
	}
	
	@GetMapping("/foodProduct/{id}")
	public ResponseStructure<FoodProducts> getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductsById(id);
	}

	@DeleteMapping("/foodProduct/{id}")
	public ResponseStructure<String> deleteFoodProduct(@PathVariable int id) {
		return foodProductService.deleteFoodProducts(id);

	}

	@PutMapping("/foodProduct/{id}")
	public ResponseStructure<FoodProducts> updateFoodProducts(@RequestBody FoodProducts foodProduct,@PathVariable int id) {
		return foodProductService.updateFoodProducts(foodProduct,id);
	}
}
