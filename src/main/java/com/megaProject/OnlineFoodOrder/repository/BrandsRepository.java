package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.megaProject.OnlineFoodOrder.models.Brands;

public interface BrandsRepository extends JpaRepository<Brands, Integer> {
	
	@Query(value = "select * from megaproject.brands\r\n"
			+ "where brand_id in ( Select brand_id from brand_city_mapping where city = ?)",nativeQuery = true)
	List<Brands> findByBrands_city(String city);

}
