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
}
