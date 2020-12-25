package com.megaProject.OnlineFoodOrder.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;



@Service("Passwordservice")
public class OTPServiceImpl implements OTPService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findUserByOTP(String OTP) {
		return userRepository.findByOTP(OTP);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
