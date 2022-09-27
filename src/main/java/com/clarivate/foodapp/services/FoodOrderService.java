package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clarivate.foodapp.dao.FoodOrderDao;
import com.clarivate.foodapp.dto.FoodOrder;

//updating food service
@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderDao.addFoodOrder(foodOrder);
	}
	
	public List<FoodOrder> getAllFoodOrder(){
		return foodOrderDao.getFoodOrder();
	}
	
	public void delete(int id) {
		foodOrderDao.deleteFoodOrder(id);
	}
}
