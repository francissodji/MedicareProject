package com.healthcare.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{

	@Query(value="select * from cart where usercart = ?1", nativeQuery= true)
	Cart findCartByIdUser(Integer idUser);
}
