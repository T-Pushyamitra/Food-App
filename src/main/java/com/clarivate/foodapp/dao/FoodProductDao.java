package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.repository.FoodProductRepository;





@Component
public class FoodProductDao {
	@Autowired
	FoodProductRepository  foodProductRepository;
	
	public FoodProducts addFoodProduct(FoodProducts foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	
	public List<FoodProducts> getAllFoodProduct(){
		return foodProductRepository.findAll();
	}
	
	public FoodProducts getFoodProductById(int id) {
		Optional<FoodProducts> foodProduct = foodProductRepository.findById(id);
		
		if(foodProduct.isPresent()) {			
			return foodProduct.get();
		}
		else {
			return null;
		}
	}
	
	public String deleteFoodProduct(int id) {
		Optional<FoodProducts> foodProduct = foodProductRepository.findById(id);
		
		if(foodProduct.isPresent()) {
			foodProductRepository.delete(foodProduct.get());
			return "Food product data "+ id +" has been deleted successfully";
		} else {
			return "Food product with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodProducts updateFoodProduct(FoodProducts foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	
}
