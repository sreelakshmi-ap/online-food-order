package com.megaProject.OnlineFoodOrder.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;

@Service
public class UserService {
	
		@Autowired
		private UserRepository repo;
	
		
		public List<User> listAll(){
			return repo.findAll();
		}
		public User save(User user) {
			return repo.save(user);
		}
		
		public User get(int user_id) {
			return repo.findById(user_id).get();
		}
		
		public void delete(int user_id) {
	       repo.deleteById(user_id);
	    }
		

	}


