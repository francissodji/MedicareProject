package com.healthcare.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "cartmedecin")
public class CartMedecin implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idcartmedecin;


	@ManyToOne
	@MapsId("idmedecin")
	@JoinColumn(name = "idmedecin")
	private Medecin medecin;

	@ManyToOne
	@MapsId("idcart")
	@JoinColumn(name = "idcart")
	private Cart cart;
	
	
	@Column(name = "quantity")
	private int qttybuy;
	
	@Column(name = "stageitem", length = 1)
	private char stageitem; //N = new, L = save for later, S = Sold

	public CartMedecin() {}


	public CartMedecin(Medecin medecin, Cart cart, int qttybuy, char stageitem) {
		super();
		this.medecin = medecin;
		this.cart = cart;
		this.qttybuy = qttybuy;
		this.stageitem = stageitem;
	}


	public Integer getIdcartmedecin() {
		return idcartmedecin;
	}


	public void setIdcartmedecin(Integer idcartmedecin) {
		this.idcartmedecin = idcartmedecin;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public int getQttybuy() {
		return qttybuy;
	}


	public void setQttybuy(int qttybuy) {
		this.qttybuy = qttybuy;
	}


	public char getStageitem() {
		return stageitem;
	}


	public void setStageitem(char stageitem) {
		this.stageitem = stageitem;
	}


	@Override
	public String toString() {
		return "CartMedecin [idcartmedecin=" + idcartmedecin + ", medecin=" + medecin + ", cart=" + cart + ", qttybuy="
				+ qttybuy + ", stageitem=" + stageitem + "]";
	}


}
