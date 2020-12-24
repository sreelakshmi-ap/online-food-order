package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megaProject.OnlineFoodOrder.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Boolean existsByEmail(String email);
	
	//@Query("select u.email from User u")
	//List<Object> getUserEmail();
	
	Optional<User> findByEmail(String email);
	Optional<User> findByOTP(String OTP);
	//User findByUserName(String email);
	
	
	@Query(value = "select * from users where OTP=?1",nativeQuery = true)
	User FindUserByOtp(String otp);
	
	@Query(value = "select * from users where email=?1",nativeQuery = true)
	User FindUserByEmail(String email);
}
