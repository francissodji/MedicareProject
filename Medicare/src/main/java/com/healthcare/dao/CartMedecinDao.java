package com.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.CartMedecin;

@Repository
public interface CartMedecinDao extends CrudRepository<CartMedecin, Integer>{

	@Query(value="Select c.* from cartMedecin c, cart t where c.idcart = t.idcart and stageitem = ?1 and usercart = ?2", nativeQuery= true)
	List<CartMedecin> findCartMedecinByStageAndUser(char itemStage, Integer idUser);
	
	/*
	@Query(value="Select distinct c.* from cartMedecin c, cart t where c.idcart = t.idcart and stageitem = 'N' \r\n"
			+ " and t.idcart = (select idcart from cart where usercart = ?1)", nativeQuery= true)
	*/
	
	@Query(value="Select distinct c.*  from cartMedecin c, cart t where c.idcart = t.idcart and stageitem = 'N' and t.idcart = (select idcart from cart where usercart = ?1)",nativeQuery= true)
	List<CartMedecin> findUnsoldItemInCartforUser( Integer idUser);
	
	
	@Query(value="update cartmedecin set quantity = ?3 where idmedecin = ?2 and idcart = (select idcart from cart where usercart = ?1)", nativeQuery= true)
	boolean UpdateQuantityInCart(Integer idUser, Integer idmedecin, Integer newqtity);
	
	;
}

