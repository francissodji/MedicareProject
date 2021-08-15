package com.healthcare.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;


@Entity
public class Medecin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idmedecin;
	
	@Column(name = "designmedecin")
	private String designMedecin;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "qttyavail")
	private int qttyAvail;
	
	@Column(name = "unitprice")
	private double unitPrice;
	
	@Column(name ="description")
	private String description;
	
	@Column(name = "stateactivate")
	private boolean stateActivate;
	
	@Column(name = "picture", nullable = true, length = 300)
	private String picture;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idcategory", foreignKey=@ForeignKey(name="fk_MedecinCategory"))
	private Category category;


	@OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL)
	private List<CartMedecin> cartForMedecin = new ArrayList<>();
	
	
	public Medecin() {}


	public Medecin(String designMedecin, String brand, int qttyAvail, double unitPrice, String description,
			boolean stateActivate, String picture, Category category, List<CartMedecin> cartForMedecin) {
		super();
		this.designMedecin = designMedecin;
		this.brand = brand;
		this.qttyAvail = qttyAvail;
		this.unitPrice = unitPrice;
		this.description = description;
		this.stateActivate = stateActivate;
		this.picture = picture;
		this.category = category;
		this.cartForMedecin = cartForMedecin;
	}



	public Integer getIdmedecin() {
		return idmedecin;
	}


	public void setIdmedecin(Integer idmedecin) {
		this.idmedecin = idmedecin;
	}


	public String getDesignMedecin() {
		return designMedecin;
	}


	public void setDesignMedecin(String designMedecin) {
		this.designMedecin = designMedecin;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQttyAvail() {
		return qttyAvail;
	}


	public void setQttyAvail(int qttyAvail) {
		this.qttyAvail = qttyAvail;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}


	public boolean isStateActivate() {
		return stateActivate;
	}


	public void setStateActivate(boolean stateActivate) {
		this.stateActivate = stateActivate;
	}


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<CartMedecin> getCartForMedecin() {
		return cartForMedecin;
	}


	public void setCartForMedecin(List<CartMedecin> cartForMedecin) {
		this.cartForMedecin = cartForMedecin;
	}

	


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}



	@Override
	public String toString() {
		return "Medecin [idmedecin=" + idmedecin + ", designMedecin=" + designMedecin + ", brand=" + brand
				+ ", qttyAvail=" + qttyAvail + ", unitPrice=" + unitPrice + ", description=" + description
				+ ", stateActivate=" + stateActivate + ", picture=" + picture + ", category=" + category
				+ ", cartForMedecin=" + cartForMedecin + "]";
	}
	
	
}
