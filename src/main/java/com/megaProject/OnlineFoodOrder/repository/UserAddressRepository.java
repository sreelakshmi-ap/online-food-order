package com.megaProject.OnlineFoodOrder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.megaProject.OnlineFoodOrder.models.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Integer>{
	
	@Query(value="select * from megaproject.user_address where user_id=?",nativeQuery = true)
	List<UserAddress> findAddressById(int userId);
	
	@Query(value="update user_address set primary_address=0 where user_id=?",nativeQuery = true)
	public void updatePrimaryAddress(int user_id);
}
