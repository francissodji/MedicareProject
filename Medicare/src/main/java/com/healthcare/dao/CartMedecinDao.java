package com.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.CartMedecin;

@Repository
public interface CartMedecinDao extends CrudRepository<CartMedecin, Integer>{

	@Query(value="Select c.* from cartMedecin c, cart t where c.idcart = t.idcart and stageitem = ?1 and usercart = ?2", nativeQuery= true)
	List<CartMedecin> fintCartMedecinByStageAndUser(char itemStage, Integer idUser);
}

