package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.ProfilDao;
import com.healthcare.model.Medecin;
import com.healthcare.model.Profil;

@Service
public class ProfilService {
	
	@Autowired
	private ProfilDao profilDao;
	
	
	//load all profill
	public List<Profil> loadAllProfil()
	{
		List<Profil> allprofil = null;
		try {
			
			allprofil = (List<Profil>)profilDao.findAll();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allprofil;
	}

}
