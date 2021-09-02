package com.healthcare.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.healthcare.model.CartMedecin;
import com.healthcare.model.User;
import com.healthcare.service.CartMedecinService;

@RestController
@RequestMapping("/api/medecinincart")
public class CartMedecineController {
	
	@Autowired
	private CartMedecinService cartMedecinService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/unsolditems/{iduser}", produces = "application/json")
	public List<CartMedecin> getUnsoldItemInCartForAUser(@PathVariable("iduser") Integer theIdUser)
	{
		List<CartMedecin> allItemInUserCart = null;
		
		try {
			allItemInUserCart = cartMedecinService.loadUnsoldItemInCartForAUser(theIdUser);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allItemInUserCart;
	}
	
	@PostMapping(path = "/addtocart", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addUsers(@RequestBody CartMedecin medecineToCart) {


		cartMedecinService.addMedecinInCart(medecineToCart);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medecineToCart.getIdcartmedecin())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
