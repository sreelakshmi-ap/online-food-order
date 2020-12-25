package com.megaProject.OnlineFoodOrder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.Request.UserAddressRequest;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.models.UserAddress;
import com.megaProject.OnlineFoodOrder.repository.UserAddressRepository;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;

@Service
public class UserAddressService {

	@Autowired
	private UserAddressRepository userAdresssRepository;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	UserAddressRepository userAddressrepo;

	public List<UserAddress> getAllAddress() {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int userId = currentUser.getUser_id();
		return userAdresssRepository.findAddressById(userId);
	}

	public UserAddress addAddress(UserAddressRequest userAddressRequest) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int user_id = currentUser.getUser_id();
		UserAddress userAddress = new UserAddress();
		userAddress.setAddress(userAddressRequest.getAddress());
		userAddress.setAddress_label(userAddressRequest.getAddress_label());
		userAddress.setCity(userAddressRequest.getCity());
		userAddress.setLandmark(userAddressRequest.getLandmark());
		userAddress.setArea(userAddressRequest.getArea());
		userAddress.setUser_id(user_id);
		userAddress.setPrimary_address(false);
		userAdresssRepository.save(userAddress);
		return userAddress;
	}

	public UserAddress editAddress(UserAddressRequest userAddressRequest, int addressId) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int user_id = currentUser.getUser_id();
		UserAddress userAddress = new UserAddress();
		userAddress.setAddress_id(addressId);
		userAddress.setAddress(userAddressRequest.getAddress());
		userAddress.setAddress_label(userAddressRequest.getAddress_label());
		userAddress.setCity(userAddressRequest.getCity());
		userAddress.setLandmark(userAddressRequest.getLandmark());
		userAddress.setArea(userAddressRequest.getArea());
		userAddress.setUser_id(user_id);
		userAddress.setPrimary_address(false);
		userAdresssRepository.save(userAddress);
		return userAddress;
	}

	public MessageResponse deleteById(int address_id) {
		userAddressrepo.deleteById(address_id);
		return new MessageResponse("Deleted user address successfully", HttpStatus.OK);
	}

	public MessageResponse updatePrimaryAddress(int address_id) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentEmail = authentication.getName();
		System.out.println(authentication.getName());
		User currentUser = userRepo.findByEmail(CurrentEmail).get();
		int user_id = currentUser.getUser_id();
		userAddressrepo.updatePrimaryAddress(user_id);
		UserAddress userAddress = userAddressrepo.findById(address_id).get();
		System.out.println(userAddress.getUser_id());
		userAddress.setPrimary_address(true);
		userAddressrepo.save(userAddress);
		// System.out.println(userAddress.isPrimary_address());
		return new MessageResponse(" Primary address Updated successfully", HttpStatus.OK);
	}

}
