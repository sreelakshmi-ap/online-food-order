package com.megaProject.OnlineFoodOrder.Helper;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OTPGenerator {

	public String generateRandomSpecialCharacters(int len){
		StringBuilder generatedOTP = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();

		try {

		    secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

		    for (int i = 0; i < len; i++) {
		        generatedOTP.append(secureRandom.nextInt(9));
		    }
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}

		return generatedOTP.toString();

	}

}
