package com.clarivate.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.repository.FoodProductRepository;

@Component
public class FoodProductDao {

	@Autowired
	FoodProductRepository foodProductRepository;

	public void addProduct(FoodProducts foodProduct) {
		foodProductRepository.save(foodProduct);
	}

	public List<FoodProducts> getAllProducts() {
		return foodProductRepository.findAll();
	}

}
