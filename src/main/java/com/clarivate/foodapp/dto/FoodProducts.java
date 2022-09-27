package com.clarivate.foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "foodProduct")
public class FoodProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String about;
	private boolean availability;
	private float price;

	@ManyToOne
	@JoinColumn
	Menu menu;

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param about
	 * @param availability
	 * @param price
	 * @param menu
	 */
	public FoodProducts(int id, String name, String type, String about, boolean availability, int price, Menu menu) {
		this.name = name;
		this.type = type;
		this.about = about;
		this.availability = availability;
		this.price = price;
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
