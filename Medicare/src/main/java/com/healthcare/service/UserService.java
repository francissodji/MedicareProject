package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.UserDao;
import com.healthcare.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao usersDao;
	
	public boolean addUsers(User user)
	{
		boolean isadd = false;
		
		if(usersDao.save(user) != null)
		{
			isadd = true;
		}
		return isadd;
	}
	
	public List<User> loadAllUsers()
	{
		List<User> allUsers = null;
		
		allUsers = (List<User>)usersDao.findAll();
		
		return allUsers;
	}
}
