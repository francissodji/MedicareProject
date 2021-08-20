package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Category;
import com.healthcare.model.User;
import com.healthcare.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allusers", produces = "application/json")
	public List<Category> getTopThreeCategory () 
	{

		List<Category> topthreeCateg = null;
		
		try {
			topthreeCateg = categoryService.loadTopThreeCategory();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return topthreeCateg;
	}
}
