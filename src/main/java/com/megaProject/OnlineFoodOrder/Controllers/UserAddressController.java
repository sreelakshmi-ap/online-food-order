package com.megaProject.OnlineFoodOrder.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.megaProject.OnlineFoodOrder.Request.UserAddressRequest;
import com.megaProject.OnlineFoodOrder.Response.ListAndMessageResponse;
import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Services.UserAddressService;
import com.megaProject.OnlineFoodOrder.models.UserAddress;

@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

	@Autowired
	UserAddressService userAddressService;

	@GetMapping("/getAllAddress")
	public ListAndMessageResponse getAllAddress() {
		List<UserAddress> userAddress = userAddressService.getAllAddress();
		return new ListAndMessageResponse(userAddress, HttpStatus.OK, userAddress.size());
	}

	@PostMapping("/addAddress")
	public UserAddress addAddress(@RequestBody UserAddressRequest userAddressRequest) {
		return userAddressService.addAddress(userAddressRequest);
	}

	@PutMapping("/editAddress")
	public UserAddress editAddress(@RequestBody UserAddressRequest userAddressRequest, @RequestParam int addressId) {
		return userAddressService.editAddress(userAddressRequest, addressId);
	}

	@DeleteMapping("/deleteAddress")
	public MessageResponse deleteAddressById(@RequestParam int addressId) {
		return userAddressService.deleteById(addressId);
	}

	@PutMapping("/updatePrimaryAddress")
	public MessageResponse updatePrimaryAddress(@RequestParam int addressId) {
		return userAddressService.updatePrimaryAddress(addressId);
	}

}