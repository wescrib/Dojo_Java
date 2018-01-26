package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.TagRepo;
import com.project.Authentication.models.*;

@Service
public class TagService {
	// Member variables / service initializations go here
	private TagRepo tagRepo;
		
	public TagService(TagRepo tagRepo){
		this.tagRepo = tagRepo;

	}


	public void create(TagModel tag){
		tagRepo.save(tag);
	}

	public void update(TagModel tag){
		tagRepo.save(tag);
	}

	public ArrayList<TagModel> all(){
		return(ArrayList<TagModel>)tagRepo.findAll();
	}

	public TagModel findById(long id){
		return (TagModel) tagRepo.findOne(id);
	}

	public void destroy(long id){
		tagRepo.delete(id);
	}


	
	// Crud methods to act on services go here.
}