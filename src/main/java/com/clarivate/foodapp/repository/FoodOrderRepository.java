package com.clarivate.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.FoodOrder;

public interface FoodOrderRepository  extends JpaRepository<FoodOrder, Integer>{

	FoodOrder findByUserIdAndId(int id,int id1);

}
