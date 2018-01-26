package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.BundleRepo;
import com.project.Authentication.models.*;

@Service
public class BundleService {
	// Member variables / service initializations go here
	private BundleRepo bundleRepo;
		
	public BundleService(BundleRepo bundleRepo){
		this.bundleRepo = bundleRepo;

	}


	public void create(Bundle answer){
		bundleRepo.save(answer);
	}

	public void update(Bundle answer){
		bundleRepo.save(answer);
	}

	public ArrayList<Bundle> all(){
		return(ArrayList<Bundle>)bundleRepo.findAll();
	}

	public Bundle findById(long id){
		return (Bundle) bundleRepo.findOne(id);
	}

	public void destroy(long id){
		bundleRepo.delete(id);
	}


	
	// Crud methods to act on services go here.
}