package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.UserBundleRepo;
import com.project.Authentication.models.*;

@Service
public class UserBundleService {
	// Member variables / service initializations go here
	private UserBundleRepo userBundleRepo;
	private UserService userService;
	private BundleService bundleService;
		
	public UserBundleService(UserBundleRepo userBundleRepo,UserService userService,BundleService bundleService){
		this.userBundleRepo = userBundleRepo;
		this.bundleService = bundleService;
		this.userService = userService;
	}

	
	public void join(long user_id, long bundle_id){
		UserModel user = userService.findById(user_id);
		Bundle bundle = bundleService.findById(bundle_id);

		UserBundle test = new UserBundle(user, bundle);
		userBundleRepo.save(test);

	}
}// Crud methods to act on services go here.
