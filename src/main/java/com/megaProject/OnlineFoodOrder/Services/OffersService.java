package com.megaProject.OnlineFoodOrder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.models.Offers;
import com.megaProject.OnlineFoodOrder.repository.OffersRepository;

@Service
public class OffersService {
	
	@Autowired
	private OffersRepository offersrepo;
	
	public List<Offers> getAllOffers(){
		return offersrepo.findAll();
	}
}
