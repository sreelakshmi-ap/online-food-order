package com.megaProject.OnlineFoodOrder.Services;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.megaProject.OnlineFoodOrder.models.JwtBlacklist;
import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.JwtBlacklistRepository;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;

@Service
public class JwtBlacklistService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	JwtBlacklistRepository repo;
	
	public void logout() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	    String token = request.getHeader("Authorization").split(" ")[1];
	    System.out.println(token);

	    Authentication authentication=(Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentUserName = authentication.getName();
		Optional<User> currentUser=userRepo.findByEmail(CurrentUserName);
		int id = currentUser.get().getUser_id();
		
		
	    JwtBlacklist blacklist=new JwtBlacklist();
	    blacklist.setToken(token);
	    blacklist.set_id(id);
	    repo.save(blacklist);
	    
	}

	
}
