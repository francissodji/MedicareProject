package com.healthcare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Medecin;

@Repository
public interface MedecinDao extends CrudRepository<Medecin, Integer>{

	
}
