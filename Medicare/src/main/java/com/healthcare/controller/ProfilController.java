package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Medecin;
import com.healthcare.model.Profil;
import com.healthcare.service.ProfilService;

@RestController
@RequestMapping("/profil")
public class ProfilController {

	@Autowired
	private ProfilService profilService;
	
	
	//load all profil
	public List<Profil> loadAllMedecin()
	{
		List<Profil> allprof = null;
		try {
			
			allprof = (List<Profil>)profilService.loadAllProfil();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allprof;
	}
}
