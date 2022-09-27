package com.clarivate.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.repository.FoodProductRepository;





@Component
public class FoodProductDao {
	@Autowired
	FoodProductRepository  foodProductRepository;
	
	public void add(FoodProducts foodProduct) {
	
		foodProductRepository.save(foodProduct);
	}
	
	public List<FoodProducts > getProducts(){
		return foodProductRepository.findAll();
	}
	
	public void deleteByProductId(int id) {
		foodProductRepository.deleteById(id);
	}
}
