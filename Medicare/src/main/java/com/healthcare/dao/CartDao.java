package com.healthcare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{

}
