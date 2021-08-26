package com.healthcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.MedecinDao;
import com.healthcare.model.Category;
import com.healthcare.model.Medecin;

@Service
public class MedecinService {

	
	@Autowired
	private MedecinDao medecinDao;
	
	
	//list top 3 medecin
	public List<Medecin> loadTopThreeMedecin()
	{
		List<Medecin> topthree = null;
		try {
			
			topthree = (List<Medecin>)medecinDao.findTopThreeMedecin();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return topthree;
	}
	
	
	//list all medecin
	public List<Medecin> loadAllMedecin()
	{
		List<Medecin> allmedecin = null;
		try {
			
			allmedecin = (List<Medecin>)medecinDao.findAll();			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allmedecin;
	}
	
	
	//add new medecin
	public boolean addNewMedecin(Medecin medecin)
	{
		boolean itSaved = false;
		
		try {
			if(medecinDao.save(medecin) != null)
			{
				itSaved = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return itSaved;
	}
	
	
	//find medecin by Id
	public Optional<Medecin> loadMedecinById(Integer theIdMedec)
	{
		Optional<Medecin> amedecin = null;
		try {
			
			amedecin = medecinDao.findById(theIdMedec);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return amedecin;
	}
	
}
