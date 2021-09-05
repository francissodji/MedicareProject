package com.healthcare.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.healthcare.model.Cart;
import com.healthcare.model.Medecin;
import com.healthcare.service.CartService;

@RestController
@RequestMapping("/api/cart")

public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/addcart", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addCart(@RequestBody Cart cart) {

		
		cartService.addCart(cart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idmedecin}").buildAndExpand(cart.getIdcart())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
