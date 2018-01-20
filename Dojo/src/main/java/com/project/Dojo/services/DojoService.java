package com.project.Dojo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Dojo.models.DojoModel;
import com.project.Dojo.repositories.DojoRepo;

@Service
public class DojoService {
	private DojoRepo dojoRepo;
	// Member variables / service initializations go here
		
	public DojoService(DojoRepo dojoRepo){
		this.dojoRepo = dojoRepo;
	}

	public void create(DojoModel dojo){
		dojoRepo.save(dojo);
	}

	public void edit(DojoModel dojo){
		dojoRepo.save(dojo);
	}

	public void delete(long id){
		dojoRepo.delete(id);
	}

	public DojoModel findById(long id){
		return dojoRepo.findOne(id);
	}

	public ArrayList<DojoModel> all(){
		return(ArrayList<DojoModel>)dojoRepo.findAll();

	}

	
	// Crud methods to act on services go here.
}
