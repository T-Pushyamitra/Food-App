package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.ItemDao;
import com.clarivate.foodapp.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;
	
	public Item saveItem(Item item) {
		return itemDao.addItem(item);
	}
	
	public List<Item> getAllItems(){
		return itemDao.getAllItems();
	}
	
}
