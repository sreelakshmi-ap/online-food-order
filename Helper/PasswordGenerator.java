package com.megaProject.OnlineFoodOrder.Helper;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {

	public String generateRandomSpecialCharacters(int len){
		String AB="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd=new Random();
		
		StringBuilder sb= new StringBuilder(len);
		for(int i=0; i<len;i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
		}

	}


