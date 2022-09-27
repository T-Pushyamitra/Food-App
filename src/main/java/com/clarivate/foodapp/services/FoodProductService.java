package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodProductDao;
import com.clarivate.foodapp.dto.FoodProducts;

@Service
public class FoodProductService {
	
	
	@Autowired
	FoodProductDao foodproductdao;
	
	public FoodProducts saveProduct(FoodProducts foodProducts) {
		 foodproductdao.add(foodProducts);
		return foodProducts;
	}
	public List<FoodProducts> getAllFoodProducts(){
		return foodproductdao.getProducts();
	}

}






