package com.clarivate.foodapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodProductDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	
	public ResponseStructure<FoodProducts> saveFoodProducts(FoodProducts foodProduct) {
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();

		FoodProducts foodProduct1 = foodProductDao.addFoodProduct(foodProduct);

		if (foodProduct1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(foodProductDao.addFoodProduct(foodProduct1));
		}
		return responseStructure;
	}

}
