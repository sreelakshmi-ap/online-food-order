package com.megaProject.OnlineFoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megaProject.OnlineFoodOrder.models.Offers;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer> {

}
