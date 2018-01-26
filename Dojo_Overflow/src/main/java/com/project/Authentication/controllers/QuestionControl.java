package com.project.Authentication.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.Authentication.models.AnswerModel;
import com.project.Authentication.models.QuestionModel;
import com.project.Authentication.models.TagModel;
import com.project.Authentication.models.UserModel;
import com.project.Authentication.repositories.*;
import com.project.Authentication.services.AnswerService;
import com.project.Authentication.services.QuestionService;
import com.project.Authentication.services.TagService;
import com.project.Authentication.services.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class QuestionControl{
	//Member variables go here
	@Autowired
	private QuestionService questionService;
	private TagService tagService;
	private AnswerService answerService;

	public QuestionControl(QuestionService questionService, TagService tagService, AnswerService answerService){
		this.questionService = questionService;
		this.tagService = tagService;
		this.answerService = answerService;
	}

	@RequestMapping("questions")
	public String questions(HttpSession session, Model model){
		if(session.getAttribute("current_user") != null){
			ArrayList<QuestionModel> questionList = questionService.all();
			model.addAttribute("questions",questionList);
			return "questions";
		}else{
			return "redirect:/register";
		}		
	}

	@RequestMapping("questions/ask")
	public String askQuestion(@ModelAttribute("postQuestion") QuestionModel question, HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		
		if(loggedInUser!=null){
			return "askQuestion";
		}else{
			return "redirect:/register";
		}
	}

	@PostMapping("questions/ask")
	public String postQuestion(@Valid @ModelAttribute("postQuestion") QuestionModel question, BindingResult result, HttpSession session,@RequestParam("tags") String tags){
		if(result.hasErrors()){
			return "askQuestion";
		}else{
			UserModel loggedInUser = (UserModel) session.getAttribute("current_user");

			if(loggedInUser!=null){
				question.setUser(loggedInUser);

				String[] tagArr = tags.split(",");
				ArrayList<TagModel> tagArryList = new ArrayList<TagModel>();

				for(int i=0; i< tagArr.length; i++){
					TagModel t = new TagModel();
					t.setSubject(tagArr[i]);
					tagService.create(t);


					tagArryList.add( t );
				}

				question.setTag(tagArryList);
				questionService.create(question);

				return "redirect:/questions";
			}else{
				return "redirect:/register";
			}
		}
	}
	@RequestMapping("questions/ask/display/{id}")
	public String display(@PathVariable("id")long id, Model model){
		QuestionModel question = questionService.findById(id);
		ArrayList<QuestionModel> questionsAll = questionService.all();
		List<AnswerModel> answers = question.getAnswer();
		System.out.println(answers);
		model.addAttribute("question", question);
		model.addAttribute("a", new AnswerModel());
		model.addAttribute("answers",answers);
		return "displayQuestion";

	}

	@PostMapping("questions/ask/display/{id}")
	public String answerFun(@Valid @ModelAttribute("a")AnswerModel answers, BindingResult result, HttpSession session, @PathVariable("id")long id){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(result.hasErrors()){
			return "displayQuestion";
		}else{
			QuestionModel qid = questionService.findById(id);	
			answers.setUser(loggedInUser);
			answers.setQuestion(qid);
			AnswerModel test = new AnswerModel(answers.getQuestion(),answers.getUser(),answers.getAnswer());
			answerService.create(test);

			return "redirect:/questions/ask/display/" + id;
		}
	}
}
