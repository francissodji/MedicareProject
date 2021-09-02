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

@Repository()
public interface UserDao extends CrudRepository<User,Integer>{
	
	
	@Query(value="select * from user where username = ?1", nativeQuery= true)
	User findByUsername(String ausername);
	
	@Query(value="select * from user where username = ?1 and password = ?2", nativeQuery= true)
	User findByUsernameAndPassword(String ausername, String apassword);
	
	@Query(value="select * from user where iduser = (select max(iduser) from user)", nativeQuery= true)
	User findLastUser();
	
	@Query(value="select * from user where username = ?1 and password = ?2 and idprofil in (1,2)", nativeQuery= true)
	User findByAdminByUsernameAndPassword(String ausername, String apassword);
	
	/*
	@Query("from User u where u.stateconnect = true")
	List<User> findAllConnectedUsers();
	
	
	@Transactional
	@Modifying
	@Query("UPDATE user u set password =:aUsername where u.username = :aPassword")
	boolean changePassword(String aUsername, String aPassword);
	
	*/

}
