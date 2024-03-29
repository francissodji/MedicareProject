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
	public User loadUserByUserNameAndPassword(String theUserName, String thePassword)
	{
		User aUser = null;
		
		if(theUserName != null && thePassword != null) {
			aUser = usersDao.findByUsernameAndPassword(theUserName,thePassword);
		}
		
		return aUser;
	}
	
	public User loadUserLastUser()
	{
		User aUser = null;
		
		aUser = usersDao.findLastUser();
		
		return aUser;
	}
	
	
	//validate user login
	public User validateUserLogin(String theUserName, String theUserPw) throws Exception
	{

		User connectedUser = null;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(theUserPw); //crypt the entered password
		
		try
		{
			connectedUser = loadUserByUserNameAndPassword(theUserName,aCryptedPw);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
			
		return connectedUser;
	}
	
	//validate user login
	public User validateAdminUserLogin(String theUserName, String theUserPw) throws Exception
	{

		User connectedUser = null;
		
		CryptPassword passwordCrypter = new CryptPassword();
		
		String aCryptedPw = passwordCrypter.CryptPasswordSHA3256(theUserPw); //crypt the entered password
		
		try
		{
			connectedUser = loadUserByUserNameAndPassword(theUserName,aCryptedPw);
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
			
		return connectedUser;
	}
}
