package com.healthcare.controller;

import java.net.URI;

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

import com.healthcare.model.Profil;
import com.healthcare.model.User;
import com.healthcare.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	private Profil profil;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> registerUser(@RequestBody User theUser) {

		profil = new Profil(); 
		profil.setIdprofil(1);
		theUser.setProfil(profil);
		userService.addUsers(theUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theUser.getIdUser())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/login/{username}/{password}")
	public User validateUser (@PathVariable("username") String theUsername, @PathVariable("username") String thePassword)
	{
		User aValideUser = null;
		
		aValideUser = userService.validateUserLogin(theUsername,thePassword);
		
		return aValideUser;
	}
}
