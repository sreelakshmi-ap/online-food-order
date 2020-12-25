package com.megaProject.OnlineFoodOrder.Services;

import java.util.Optional;

import com.megaProject.OnlineFoodOrder.models.User;


public interface OTPService {
	public Optional<User> findUserByEmail(String email);
	public Optional<User> findUserByOTP(String OTP);
	public void save(User user);

}
