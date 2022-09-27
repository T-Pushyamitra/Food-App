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

	public List<FoodOrder> getFoodOrder() {
		return foodOrderRepository.findAll();
	}

	public void deleteFoodOrder(int id) {
		foodOrderRepository.deleteById(id);
	}

	public FoodOrder getUserById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		return foodOrder.get();
	}

}
