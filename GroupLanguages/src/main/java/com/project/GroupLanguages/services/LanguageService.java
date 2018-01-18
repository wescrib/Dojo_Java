package com.project.GroupLanguages.services;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.GroupLanguages.repositories.*;
import com.project.GroupLanguages.models.*;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	// Member variables / service initializations go here
		
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}

	public void create(Languages language){
		languageRepository.save(language);
	}

	public ArrayList<Languages> all(){
		return (ArrayList<Languages>)languageRepository.findAll();
	}

	public void edit(Languages language){
		languageRepository.save(language);
	}

	public void delete(long id){
		languageRepository.delete(id);
	}

	public Languages findById(long id){
		return languageRepository.findOne(id);
	}


	
	// Crud methods to act on services go here.
}
