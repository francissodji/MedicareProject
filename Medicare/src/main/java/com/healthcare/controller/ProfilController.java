package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Medecin;
import com.healthcare.model.Profil;
import com.healthcare.service.ProfilService;

@RestController
@RequestMapping("/api/profil")
public class ProfilController {

	@Autowired
	private ProfilService profilService;
	
	
	//load all profil
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allprofil", produces = "application/json")
	public List<Profil> loadAllProfil()
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
