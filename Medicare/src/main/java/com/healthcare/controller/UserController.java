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
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allusers", produces = "application/json")
	public List<User> getAllUsers () 
	{

		List<User> allUsers = null;
		try {
			allUsers = userService.loadAllUsers();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allUsers;
	}
	
	//Add User
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> registerUser(@RequestBody User theUser) {

		Integer idUser = userService.loadAllUsers().size() + 1;

		theUser.setIdUser(idUser);
		userService.addUsers(theUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theUser.getIdUser())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public User validateUser(@RequestBody User theUser) throws Exception
	{
		User aValideUser = null;
		String tempUsername = theUser.getUserName();
		String tempPassWord = theUser.getPassWord();
		

			if(tempUsername != null && tempPassWord != null)
			{
				
				aValideUser = userService.validateUserLogin(tempUsername,tempPassWord);
				
				System.out.println("In Controler ==> "+aValideUser.toString());
			}
			
			if(aValideUser == null)
			{
				throw new Exception("In controller ==> Bad credential");
			}
			
			
		return aValideUser;
	}
	
	//Register user
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/lastuser", produces = "application/json")
	public User getLastUser ()
	{
		User theLastuser = null;
		
		try {
			theLastuser = userService.loadUserLastUser();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return theLastuser;
	}
	
	
}
	
