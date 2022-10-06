package com.clarivate.foodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.FoodProducts;


@Repository
public interface FoodProductRepository  extends JpaRepository<FoodProducts, Integer>{

		List<FoodProducts> findByNameContaining(String name);

		List<FoodProducts> findByMenuId(int id);

		List<FoodProducts> findByType(String type);

		List<FoodProducts> findByAvailability(boolean availability);
		
}

