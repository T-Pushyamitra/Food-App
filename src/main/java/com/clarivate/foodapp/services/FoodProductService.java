package com.clarivate.foodapp.services;

import java.util.List;

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

	public ResponseStructure<List<FoodProducts>> getAllFoodProducts() {

		ResponseStructure<List<FoodProducts>> responseStructure = new ResponseStructure<List<FoodProducts>>();

		List<FoodProducts> foodProductList = foodProductDao.getAllFoodProduct();

		if (foodProductList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order Details");
			responseStructure.setData(foodProductList);
		}
		return responseStructure;
	}
	
	public ResponseStructure<FoodProducts> getFoodProductsById(int id) {

		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();

		FoodProducts foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order details Obtained");
			responseStructure.setData(foodProduct);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	
	// Delete food order by id
	
	public ResponseStructure<String> deleteFoodProducts(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		FoodProducts foodProduct = foodProductDao.getFoodProductById(id);

		if (foodProduct != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order details Deleted Successfully");
			responseStructure.setData(foodProductDao.deleteFoodProduct(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	
	// Update food order by id
	
	public ResponseStructure<FoodProducts> updateFoodProducts(FoodProducts foodProduct) {
		
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();
		
		FoodProducts foodProduct1 = foodProductDao.getFoodProductById(foodProduct.getId());
		
		if (foodProduct1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("FoodProducts data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Product is present");
			responseStructure.setData(foodProductDao.updateFoodProduct(foodProduct));

		}
		return responseStructure;

	}
}
