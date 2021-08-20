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

import com.healthcare.model.User;
import com.healthcare.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allusers", produces = "application/json")
	public List<User> getAllUsers () 
	{

		List<User> allUsers = null;
		
		allUsers = userService.loadAllUsers();
		
		return allUsers;
	}
	
	//Add User
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/adduser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> registerUser(@RequestBody User theUser) {

		//Integer idUser = userService.loadAllUsers().size() + 1;

		//theUser.setIdUser(idUser);
		userService.addUsers(theUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theUser.getIdUser())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/userlogin/{username}/{password}")
	public User validateUser (@PathVariable("username") String theUsername, @PathVariable("username") String thePassword)
	{
		User aValideUser = null;
		
		aValideUser = userService.validateUserLogin(theUsername,thePassword);
		
		return aValideUser;
	}


	/*
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/latestuser", produces = "application/json")
	public User getLatestAddedUser () 
	{

		User aUser = null;
		
		//aUser = userService.loadTheLatestAddedUser();
		
		return aUser;
	}
	
	*/
	
	
	
}
	
