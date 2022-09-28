package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodProductDao;
import com.clarivate.foodapp.dao.MenuDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProducts;
import com.clarivate.foodapp.dto.Menu;


@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	@Autowired
	MenuDao menuDao;
	
	/*public ResponseStructure<FoodProducts> saveFoodProducts(FoodProducts foodProduct) {
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();

		FoodProducts foodProduct1 = foodProductDao.addFoodProduct(foodProduct);

		if (foodProduct1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(foodProductDao.addFoodProduct(foodProduct1));
		}
		return responseStructure;
	}*/
	
	public ResponseStructure<FoodProducts> saveFoodProducts(FoodProducts foodProduct, int id) {
	ResponseStructure<FoodProducts> response= new ResponseStructure<FoodProducts>();
	 
	Menu menu =menuDao.getMenuById(id);
	
	if(menu==null) {
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
        response.setMsg("Menu not found");
        response.setData(null);
		
	}
	else {
		response.setStatusCode(HttpStatus.FOUND.value());
        response.setMsg("Food Order Details");
        foodProduct.setMenu(menu);
        response.setData(foodProductDao.addFoodProduct(foodProduct));


		
	}
	return response;
	
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
			responseStructure.setMsg("Food product Details");
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
			responseStructure.setMsg("Food product details Not Found");
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
	
	public ResponseStructure<FoodProducts> updateFoodProducts(FoodProducts foodProduct,int id) {
		
		ResponseStructure<FoodProducts> responseStructure = new ResponseStructure<FoodProducts>();
		
		FoodProducts foodProduct1 = foodProductDao.getFoodProductById(id);
		
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
