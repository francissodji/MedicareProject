package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profil")
public class Profil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idprofil;
	
	
	@Column(name = "labelprofil")
	private String labelProfil;
}
