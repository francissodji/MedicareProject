package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.dao.CartMedecinDao;
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
			medecInCart = cartMedecinDao.fintCartMedecinByStageAndUser(theStatus, theIdUser);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return medecInCart;
	}
}
