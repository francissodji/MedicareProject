package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.UserDao;
import com.healthcare.general.CryptPassword;
import com.healthcare.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao usersDao;
	
	//register
	public boolean addUsers(User user)
	{
		boolean isadd = false;
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(user.getPassWord());
		
		user.setPassWord(aCryptedPw);
		
		if(usersDao.save(user) != null)
		{
			isadd = true;
		}
		return isadd;
	}
	
	
	//load all user
	public List<User> loadAllUsers()
	{
		List<User> allUsers = null;
		
		
		allUsers = (List<User>)usersDao.findAll();
		
		return allUsers;
	}
	
	
	//load by username
	public User loadUserByUserName(String theUserName)
	{
		User aUser = null;
		
		aUser = usersDao.findByUsername(theUserName);
		
		return aUser;
	}
	
	
	//validate login
	public User validateUserLogin(String theUserName, String theUserPw)
	{
		User itIsTheRealUser = null;
		User connectedUser = null;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(theUserPw); //crypt the entered password
		
		try
		{
			connectedUser = loadUserByUserName(theUserName);
			
			if (connectedUser != null)
			{
				if(connectedUser.getPassWord().equals(aCryptedPw)) //compare both crypted password
				{
					itIsTheRealUser = connectedUser;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
			
		return itIsTheRealUser;
	}
}
