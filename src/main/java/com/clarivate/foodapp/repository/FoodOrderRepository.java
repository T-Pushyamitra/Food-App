package com.clarivate.foodapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.FoodOrder;

public interface FoodOrderRepository  extends JpaRepository<FoodOrder, Integer>{

	FoodOrder findByUserIdAndId(int id,int id1);

	List<FoodOrder> findByUserId(int id);

}
