package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.QuestionRepo;
import com.project.Authentication.models.*;

@Service
public class QuestionService {
	private QuestionRepo questionRepo;

	public QuestionService(QuestionRepo questionRepo){
		this.questionRepo = questionRepo;
	}

	public void create(QuestionModel question){
		questionRepo.save(question);
	}

	public void update(QuestionModel question){
		questionRepo.save(question);
	}

	public ArrayList<QuestionModel> all(){
		return(ArrayList<QuestionModel>)questionRepo.findAll();
	}

	public QuestionModel findById(long id){
		return (QuestionModel) questionRepo.findOne(id);
	}

	public void destroy(long id){
		questionRepo.delete(id);
	}
}