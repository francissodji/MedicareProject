package com.healthcare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Category;

@Repository
public interface CategoryDao extends CrudRepository<Category, Integer>{

}
