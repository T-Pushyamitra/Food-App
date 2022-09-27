package com.clarivate.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.services.FoodProductService;

public class FoodProductController {

	@Autowired
	FoodProductService foodProductService;

	@PostMapping("/foodProduct")
	public ResponseStructure<FoodProducts> saveFoodProducts(@RequestBody FoodProducts foodProduct) {
		return foodProductService.saveFoodProducts(foodProduct);
	}
}
