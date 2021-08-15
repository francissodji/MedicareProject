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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cart")
public class Cart {
	
	//***************************************

	private static final long serialVersionUID = 8436097833452420298L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcart;
	
	@Column(name = "labelcart")
	private String labelCart;

	@OneToOne
	@JoinColumn(name = "usercart")
	@JsonIgnore
	private User user;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartMedecin> medecinInCard = new ArrayList<>();
	
	
	@Column(name = "totalprice")
	private double totalPrice;
	//***************************************
	
	public Cart() {}
	

	
	public Cart(String labelCart, User user, List<CartMedecin> medecinInCard, double totalPrice) {
		super();
		this.labelCart = labelCart;
		this.user = user;
		this.medecinInCard = medecinInCard;
		this.totalPrice = totalPrice;
	}


	public Integer getIdcart() {
		return idcart;
	}



	public void setIdcart(Integer idcart) {
		this.idcart = idcart;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<CartMedecin> getMedecinInCard() {
		return medecinInCard;
	}


	public void setMedecinInCard(List<CartMedecin> medecinInCard) {
		this.medecinInCard = medecinInCard;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	
	
	public String getLabelCart() {
		return labelCart;
	}


	public void setLabelCart(String labelCart) {
		this.labelCart = labelCart;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Cart [idcart=" + idcart + ", labelCart=" + labelCart + ", user=" + user + ", medecinInCard="
				+ medecinInCard + ", totalPrice=" + totalPrice + "]";
	}



}
