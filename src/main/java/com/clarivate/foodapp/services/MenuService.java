package com.clarivate.foodapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.clarivate.foodapp.dao.MenuDao;
import com.clarivate.foodapp.dao.ResponseStructure;
import com.clarivate.foodapp.dto.Menu;

public class MenuService {

	@Autowired
	MenuDao menuDao;
	
	public ResponseStructure<Menu> saveMenu(Menu menu){
		ResponseStructure<Menu> response = new ResponseStructure<Menu>();
		
		Menu Menu2 = menuDao.addMenu(menu);
		if(Menu2 != null) {
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setMsg("Menu added successfully");
			response.setData(Menu2);
		}
		return response;
	}
	
	public ResponseStructure<List<Menu>> getAllMenus(){
		
		ResponseStructure<List<Menu>> response = new ResponseStructure<List<Menu>>();
		List<Menu> list=menuDao.getAllMenu();
		
		if(list.isEmpty()) {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMsg("Menu not found");
			response.setData(null);
		} else {
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setMsg("Menu Details");
			response.setData(list);
			
		}
		return response;
	}
	

}
