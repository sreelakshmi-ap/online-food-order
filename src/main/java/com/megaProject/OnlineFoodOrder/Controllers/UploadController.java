package com.megaProject.OnlineFoodOrder.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.megaProject.OnlineFoodOrder.Response.MessageResponse;
import com.megaProject.OnlineFoodOrder.Services.UploadService;
import com.megaProject.OnlineFoodOrder.models.User;
import com.megaProject.OnlineFoodOrder.repository.UserRepository;




@RestController
@RequestMapping("/upload")
public class UploadController {

	private UploadService uploadService;
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	UploadController(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	@PostMapping("/uploadUserImage")
	public MessageResponse uploadUserImage(@RequestPart(value = "file") MultipartFile file) throws IOException {
		Authentication authentication=(Authentication) SecurityContextHolder.getContext().getAuthentication();
		String CurrentUserName = authentication.getName();
		User currentUser=userRepo.findByEmail(CurrentUserName).get();
	    String fileUrl= this.uploadService.uploadFile(file);
	    currentUser.setImage_path(fileUrl);
	    userRepo.save(currentUser);
	    
	    return new MessageResponse("Image uploaded susseccfully!",HttpStatus.OK);
	
	}
	
	                                                                                                                                        
	
}