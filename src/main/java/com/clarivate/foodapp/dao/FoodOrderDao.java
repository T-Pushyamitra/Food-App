package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.FoodOrder;

import com.clarivate.foodapp.repository.FoodOrderRepository;


@Component
public class FoodOrderDao {
	
	private static final Optional<FoodOrder> foodOrder = null;

	@Autowired
	FoodOrderRepository foodOrderRepository;

	public FoodOrder addFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepository.findAll();
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		
		if(foodOrder.isPresent()) {			
			return foodOrder.get();
		}
		else {
			return null;
		}
	}
	
	public String deleteFoodOrder(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		
		if(foodOrder.isPresent()) {
			foodOrderRepository.delete(foodOrder.get());
			return "Food order data "+ id +" has been deleted successfully";
		} else {
			return "Food order with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}


	public FoodOrder updateFoodOrderSave(FoodOrder foodOrder, String status, int id) {
		return foodOrderRepository.save(foodOrder);
	}

}
