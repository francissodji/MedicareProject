package com.healthcare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.healthcare.model.Category;
import com.healthcare.model.Medecin;
import com.healthcare.model.User;
import com.healthcare.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/topthreecategory", produces = "application/json")
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/addcategory", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addUsers(@RequestBody Category category) {


		categoryService.addNewCategory(category);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getIdcateg())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allcategories", produces = "application/json")
	public List<Category> getAllCategory () 
	{

		List<Category> allcateg = null;
		
		try {
			allcateg = categoryService.loadAllCategories();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allcateg;
	}
}
