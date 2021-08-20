package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.CategoryDao;
import com.healthcare.model.Category;


@Service
public class CategoryService {

	
	@Autowired
	private CategoryDao categoryDao;
	
	//Top 3 category
	public List<Category> loadTopThreeCategory()
	{
		List<Category> topthree = null;
		try {
			
			topthree = (List<Category>)categoryDao.findTopThreeCategory();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return topthree;
	}
	
	
	//all category
	public List<Category> loadAllCategories()
	{
		
		List<Category> allCateg = null;
		try {
			
			allCateg = (List<Category>)categoryDao.findAll();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allCateg;
		
	} 
}
