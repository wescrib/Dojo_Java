package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.AnswerRepo;
import com.project.Authentication.models.*;

@Service
public class AnswerService {
	// Member variables / service initializations go here
	private AnswerRepo answerRepo;
		
	public AnswerService(AnswerRepo answerRepo){
		this.answerRepo = answerRepo;

	}


	public void create(AnswerModel answer){
		answerRepo.save(answer);
	}

	public void update(AnswerModel answer){
		answerRepo.save(answer);
	}

	public ArrayList<AnswerModel> all(){
		return(ArrayList<AnswerModel>)answerRepo.findAll();
	}

	public AnswerModel findById(long id){
		return (AnswerModel) answerRepo.findOne(id);
	}

	public void destroy(long id){
		answerRepo.delete(id);
	}


	
	// Crud methods to act on services go here.
}