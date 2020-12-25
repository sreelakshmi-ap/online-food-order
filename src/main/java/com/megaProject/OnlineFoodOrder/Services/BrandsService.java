package com.megaProject.OnlineFoodOrder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.models.Brands;
import com.megaProject.OnlineFoodOrder.repository.BrandsRepository;

@Service
public class BrandsService {

	@Autowired
	private BrandsRepository brandsrepo;

	public List<Brands> getAllBrands() {
		return brandsrepo.findAll();
	}

	public List<Brands> getNearByBrands(String city) {
		return brandsrepo.findByBrands_city(city);
	}
}
