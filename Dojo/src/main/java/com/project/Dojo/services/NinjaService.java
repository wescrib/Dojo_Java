package com.project.Dojo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Dojo.models.NinjaModel;
import com.project.Dojo.repositories.NinjaRepo;

@Service
public class NinjaService {
	private NinjaRepo ninjaRepo;
	// Member variables / service initializations go here
	
	public NinjaService(NinjaRepo ninjaRepo){
		this.ninjaRepo = ninjaRepo;
	}

	public void create(NinjaModel ninja){
		ninjaRepo.save(ninja);
	}

	public void edit(NinjaModel ninja){
		ninjaRepo.save(ninja);
	}

	public void delete(long id){
		ninjaRepo.delete(id);
	}

	public NinjaModel findById(long id){
		return ninjaRepo.findOne(id);
	}

	public ArrayList<NinjaModel> all(){
		return(ArrayList<NinjaModel>)ninjaRepo.findAll();

	}

	
	// Crud methods to act on services go here.
}
