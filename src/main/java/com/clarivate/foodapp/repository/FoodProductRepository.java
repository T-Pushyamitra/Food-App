package com.clarivate.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.FoodProducts;


@Repository
public interface FoodProductRepository  extends JpaRepository<FoodProducts, Integer>{

}
