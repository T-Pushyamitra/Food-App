package com.clarivate.foodapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "menu",fetch=FetchType.LAZY)
	private List<FoodProducts> foodProducts;

	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonManagedReference
	public List<FoodProducts> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProducts> foodProducts) {
		this.foodProducts = foodProducts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}