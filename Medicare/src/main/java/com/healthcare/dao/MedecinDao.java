package com.healthcare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Medecin;

@Repository
public interface MedecinDao extends CrudRepository<Medecin, Integer>{

	@Query(value="select * from medecin LIMIT 3", nativeQuery= true)
	List<Medecin> findTopThreeMedecin();
	
	@Query(value="select idmedecin, brand, description, designmedecin, picture, qttyavail, "
			+ "stateactivate, unitprice, idcategory from medecin", nativeQuery= true)
	List<Medecin> findAllTheMedecine();
	
	//search
	@Query(value="Select * from Medecin where designmedecin like '%?1%'", nativeQuery= true)
	List<Medecin> findAllMedecineFromSearch(String searchstring);
	
	//Find idexist in cart
	@Query(value="select * from medecin where idmedecin in (select distinct idmedecin from cartmedecin) and idmedecin = ?1",nativeQuery= true)
	Medecin findMedecinExistInCart(Integer theIdmedecin);
}
