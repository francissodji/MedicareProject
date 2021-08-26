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
	
	public Profil() {}

	public Profil(String labelProfil) {
		super();
		this.labelProfil = labelProfil;
	}

	public Integer getIdprofil() {
		return idprofil;
	}

	public void setIdprofil(Integer idprofil) {
		this.idprofil = idprofil;
	}

	public String getLabelProfil() {
		return labelProfil;
	}

	public void setLabelProfil(String labelProfil) {
		this.labelProfil = labelProfil;
	}

	@Override
	public String toString() {
		return "Profil [idprofil=" + idprofil + ", labelProfil=" + labelProfil + "]";
	};
	
	
}
