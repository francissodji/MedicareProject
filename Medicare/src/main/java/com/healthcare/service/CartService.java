package com.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.CartDao;
import com.healthcare.model.Cart;

@Service
public class CartService {

	
	@Autowired
	private CartDao cartDao;
	
	public Cart loadCartByIdUser(Integer theIdUser)
	{
		Cart userCart = null;
		
		try {
			userCart = cartDao.findCartByIdUser(theIdUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return userCart;
	}
}
