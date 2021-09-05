package com.healthcare.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.healthcare.model.Medecin;
import com.healthcare.service.MedecinService;

@RestController
@RequestMapping("/api/medecine")
public class MedecinController {
	
	@Autowired
	private MedecinService medecinService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allmedecine", produces = "application/json")
	public List<Medecin> getAllMedecin () 
	{

		List<Medecin> allMedec = null;
		
		try {
			allMedec = medecinService.loadAllMedecin();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allMedec;
	}
	
	
	/*
	//search
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/allmedecinesearch/{designmedecin}", produces = "application/json")
	public List<Medecin> getAllMedecinFromSearch (@PathVariable("designmedecin") String thedesignation) 
	{

		List<Medecin> allMedec = null;
		
		try {
			allMedec = medecinService.loadAllMedecinFromSearch(thedesignation);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allMedec;
	}
	*/
	
	//Add new medecine
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/addmedecine", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addUsers(@RequestBody Medecin medecin) {

		//Integer idMedec = medecinService.loadAllMedecin().size() + 1;

		//medecin.setIdmedecin(idMedec);
		medecinService.addNewMedecin(medecin);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idmedecin}").buildAndExpand(medecin.getIdmedecin())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	//list all medecin
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/topthreemedecine", produces = "application/json")
	public List<Medecin> getTopThreeMedecin () 
	{

		List<Medecin> alltop3Medec = null;
		
		try {
			alltop3Medec = medecinService.loadTopThreeMedecin();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return alltop3Medec;
	}
	
	//Load Medecin by Id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/amedecine/{idmedecin}", produces = "application/json")
	public Optional<Medecin> getOneUsers (@PathVariable("idmedecin") Integer theidUser) 
	{

		Optional<Medecin> aMedec = null;
		try {
			aMedec = medecinService.loadMedecinById(theidUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return aMedec;

	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/ismedecineexist/{idmedecin}", produces = "application/json")
	public boolean IsMedecineIncart (@PathVariable("idmedecin") Integer theidUser) 
	{
		boolean itExist = false;
		
		Medecin aMedecin = null;
		try {
			aMedecin = medecinService.loadMedecinExistInCart(theidUser);
			if(aMedecin != null)
			{
				itExist = true;
			}
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return itExist;

	}
	
	
}
