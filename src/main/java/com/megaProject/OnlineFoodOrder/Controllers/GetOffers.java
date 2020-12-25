package com.megaProject.OnlineFoodOrder.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;

import com.megaProject.OnlineFoodOrder.Services.OffersService;
import com.megaProject.OnlineFoodOrder.models.Offers;

@RestController
@RequestMapping("/offers")
public class GetOffers {

	@Autowired
	private OffersService offersService;

	@GetMapping("/getAllOffers")
	public ListAndMessageResponse getOffers() throws NoSuchElementException {
		List<Offers> offersList= offersService.getAllOffers();
		return new ListAndMessageResponse(offersList, HttpStatus.OK, offersList.size() );
	}
}
