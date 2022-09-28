package com.clarivate.foodapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.repository.MenuRepository;

@Component
public class MenuDao {
	
	@Autowired
	MenuRepository menuRepository;
	
	public Menu addMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public List<Menu> getAllMenu(){
		return menuRepository.findAll();
	}

}
