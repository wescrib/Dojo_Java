package com.project.Authentication.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.Authentication.repositories.QuesTagRepo;
import com.project.Authentication.models.*;
import com.project.Authentication.models.QuestionTagModel;

@Service
public class QuesTagService {
	// Member variables / service initializations go here
	private QuesTagRepo quesTagRepo;
	@Autowired
	private QuestionService questionService;
	private TagService tagService;
		
	public QuesTagService(QuesTagRepo quesTagRepo, QuestionService questionService, TagService tagService){
		this.quesTagRepo = quesTagRepo;
		this.questionService = questionService;
		this.tagService = tagService;

	}

	public void join(long question_id, long tag_id){

		/**TAKING QUESTION ID AND TAG ID (BY FINDBYID METHOD FROM SERVICES), AND JOINING THE TWO */

		QuestionModel question = questionService.findById(question_id);
		TagModel tag = tagService.findById(tag_id);

		QuestionTagModel test = new QuestionTagModel(question, tag);
		quesTagRepo.save(test);
	}
}