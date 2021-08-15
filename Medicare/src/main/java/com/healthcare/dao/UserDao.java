package com.healthcare.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.healthcare.model.User;

@Qualifier("UserDao")
@Repository
public interface UserDao extends CrudRepository<User,Integer>{
	
	/*
	@Query("from User where useruame=:aUsername")
	User findByUsername(String aUsername);
	
	@Query("from User u where u.stateconnect = true")
	List<User> findAllConnectedUsers();
	
	
	@Transactional
	@Modifying
	@Query("UPDATE user u set password =:aUsername where u.username = :aPassword")
	boolean changePassword(String aUsername, String aPassword);
	*/
	

}
