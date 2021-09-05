package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.CartMedecinDao;
import com.healthcare.model.Cart;
import com.healthcare.model.CartMedecin;

@Service
public class CartMedecinService {

	@Autowired
	private CartMedecinDao cartMedecinDao;
	
	//add new medecin in cart
	public boolean addMedecinInCart(CartMedecin cartMedecin)
	{
		boolean itSaved = false;
		
		try {
			if(cartMedecinDao.save(cartMedecin) != null)
			{
				itSaved = true;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return itSaved;
	} 
	
	//List all medecin by stageItem
	public List<CartMedecin> loadAllMedecinInCartByStageAndIdUser(char theStatus, Integer theIdUser)
	{
		List<CartMedecin> medecInCart = null;
		
		try {
			medecInCart = cartMedecinDao.findCartMedecinByStageAndUser(theStatus, theIdUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return medecInCart;
	}
	
	
	//List of all Unsold item in User's cart
	public List<CartMedecin> loadUnsoldItemInCartForAUser(Integer theIdUser)
	{
		List<CartMedecin> medecInCart = null;
		
		try {
			medecInCart = cartMedecinDao.findUnsoldItemInCartforUser(theIdUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return medecInCart;
	}
	
	
	public boolean updateQuantityInCart(Integer theIdUser, Integer theIdMedecin, Integer theNewQtty)
	{
		boolean isUpdate = false;
		
		try {
			isUpdate = cartMedecinDao.UpdateQuantityInCart(theIdUser, theIdMedecin, theNewQtty);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return isUpdate;
	}
	

}
