package com.healthcare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.CartMedecin;

@Repository
public interface CartMedecinDao extends CrudRepository<CartMedecin, Integer>{

}
