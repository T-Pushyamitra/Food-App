package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.repository.ItemRepository;

@Component
public class ItemDao {

	private static final Optional<Item> Item = null;
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item  addItem(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	
	public Item getItemById(int id) {
		Optional<Item> item = itemRepository.findById(id);
		return item.get();
	}
	
}
