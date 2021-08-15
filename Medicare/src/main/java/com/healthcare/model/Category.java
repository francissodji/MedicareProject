package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcateg;
	
	@Column(name = "libelcateg")
	private String libelCateg;
	
	
	public Category() {}


	public Category(String libelCateg) {
		super();
		this.libelCateg = libelCateg;
	}


	public Integer getIdcateg() {
		return idcateg;
	}


	public void setIdcateg(Integer idcateg) {
		this.idcateg = idcateg;
	}


	public String getLibelcateg() {
		return libelCateg;
	}


	public void setLibelcateg(String libelcateg) {
		this.libelCateg = libelcateg;
	}


	@Override
	public String toString() {
		return "Category [idcateg=" + idcateg + ", libelcateg=" + libelCateg + "]";
	}
	
	
}
