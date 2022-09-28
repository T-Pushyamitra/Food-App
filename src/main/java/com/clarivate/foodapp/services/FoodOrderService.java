package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.FoodOrderDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.FoodOrder;

@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao foodOrderDao;

	// Create new food order
	public ResponseStructure<FoodOrder> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		
		FoodOrder foodOrder1 = foodOrderDao.addFoodOrder(foodOrder);

		if (foodOrder1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Data added into db successfully");
			responseStructure.setData(foodOrderDao.addFoodOrder(foodOrder1));
		}
		return responseStructure;
	}

	
	// Get All food orders
	
	public ResponseStructure<List<FoodOrder>> getAllFoodOrdersData() {

		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<List<FoodOrder>>();

		List<FoodOrder> foodOrderList = foodOrderDao.getAllFoodOrder();

		if (foodOrderList.isEmpty()) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("No data present in the db");
			responseStructure.setData(null);
		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order Details");
			responseStructure.setData(foodOrderList);
		}
		return responseStructure;
	}

	// Get food order by Id
	
	public ResponseStructure<FoodOrder> getFoodOrderById(int id) {

		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();

		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);

		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order details Obtained");
			responseStructure.setData(foodOrder);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;
	}

	
	// Delete food order by id
	
	public ResponseStructure<String> deleteFoodOrder(int id) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();

		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);

		if (foodOrder != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food order details Deleted Successfully");
			responseStructure.setData(foodOrderDao.deleteFoodOrder(id));
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Food order details Not Found");
			responseStructure.setData(null);
		}
		return responseStructure;

	}

	
	// Update food order by id
	
	public ResponseStructure<FoodOrder> updateFoodOrder(FoodOrder foodOrder) {
		
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		
		FoodOrder foodOrder1 = foodOrderDao.getFoodOrderById(foodOrder.getId());
		
		if (foodOrder1 == null) {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("FoodOrder data not found");
			responseStructure.setData(null);

		} else {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Food Order is present");
			responseStructure.setData(foodOrderDao.updateFoodOrder(foodOrder));

		}
		return responseStructure;

	}
}