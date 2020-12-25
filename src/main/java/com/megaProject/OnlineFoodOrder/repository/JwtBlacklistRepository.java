package com.megaProject.OnlineFoodOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.megaProject.OnlineFoodOrder.models.JwtBlacklist;

@Repository
public interface JwtBlacklistRepository extends JpaRepository<JwtBlacklist, Integer>{

	JwtBlacklist findByTokenEquals(String token);
	

}
