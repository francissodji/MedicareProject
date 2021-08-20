package com.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Category;
import com.healthcare.model.User;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer>{

	
	@Query(value="select * from category LIMIT 3", nativeQuery= true)
	List<Category> findTopThreeCategory();
}
