package com.megaProject.OnlineFoodOrder.Controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.megaProject.OnlineFoodOrder.Request.CurrentLocationRequest;
import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Services.BrandsService;
import com.megaProject.OnlineFoodOrder.Services.MenuService;
import com.megaProject.OnlineFoodOrder.models.Brands;
import com.megaProject.OnlineFoodOrder.models.Restaurants;
import com.megaProject.OnlineFoodOrder.repository.RestaurantsRepository;

@RestController
@RequestMapping("/brands")
public class BrandsController {
	
	@Autowired
	BrandsService brandsService;
	
	@Autowired
	MenuService service;
	
	@GetMapping("/getAllBrands")
	@ResponseStatus(HttpStatus.OK)
	public List<Brands> getAllBrands()
	{
		return brandsService.getAllBrands();
	}
	
	@GetMapping("/getNearbyBrands")
	@ResponseStatus(HttpStatus.OK)
	public List<Brands> getNearbyBrands(@RequestBody CurrentLocationRequest currentcity)
	{
		String city = currentcity.getCity();
		return brandsService.getNearByBrands(city);
	}
}