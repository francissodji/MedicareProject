package com.healthcare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.model.Profil;

@Repository
public interface ProfilDao extends CrudRepository<Profil,Integer>{

}
