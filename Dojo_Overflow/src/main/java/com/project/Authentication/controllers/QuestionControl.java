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
		if(session.getAttribute("current_user") != null){//IF USER IS LOGGED IN DIRECT THEM TO QUESTIONS JSP
			ArrayList<QuestionModel> questionList = questionService.all(); //THIS LINE PUTS EVERY QUESTION IN THE DB INTO AN ARRAYLIST. AN ARRAYLIST BECAUSE THE SIZE OF THE LIST WILL CHANGE OVER TIME
			model.addAttribute("questions",questionList); //MAKES THE THE ARRAYLIST OF QUESTIONLIST CALLABLE FROM THE JSP. LIKE A DICTIONARY IN DJANGO. BUT THE ENTIRE OBJECT WILL BE CALLED. GETTER IS BEING USED INSIDE JSP, NOT EXACTLY SUPER SECURE METHODOLOGY.
			return "questions";
		}else{//IF USER NOT LOGGED IN, DIRECT TO REGISTRATION
			return "redirect:/register";
		}		
	}

	@RequestMapping("questions/ask")
	public String askQuestion(@ModelAttribute("postQuestion") QuestionModel question, HttpSession session){
		/**
		 * @MODELATTRIBUTE IS TALKING TO THE NAME OF THE MODELATTRIBUTE IN THE FANCY FORM IN THE BELOW JSP, AND THEN ASSIGNING IT TO A CALLABLE VARIABLE IN THE CONTROLLER.
		 * THIS IS NOT A POSTMAPPING, BUT THE @MODEL ATTRIBUTE STILL NEEDS TO BE HERE
		 */
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		
		if(loggedInUser!=null){
			return "askQuestion";
		}else{
			return "redirect:/register";
		}
	}

	@PostMapping("questions/ask")
	public String postQuestion(@Valid @ModelAttribute("postQuestion") QuestionModel question, BindingResult result, HttpSession session,@RequestParam("tags") String tags){
		/**
		 * @VALID IS CHECKING THE MODEL REQUIREMENTS (I.E MINIMUM NUMBER OF CHARACTERS NEEDED TO POST A QUESTION)
		 * @MODELATTRIBUTE IS STILL TALKING TO THE FANCY FORM AND ASSIGNING IT A VARIABLE
		 * BINDING RESULT IS ALSO CHECKING MINIMUM REQUIREMENTS IN THE MODEL, BUT WILL SPIT OUT ERROR MESSAGES IF ANY ARE NEEDED...BASICALLY
		 * @REQUESTPARAM IS BEING USED TO TAKE WHATS IN THE TAG INPUT. WERE DOING IT LIKE THIS BECAUSE THERE ISNT AN EASY WAY TO USE THE FANCY FORM FOR TWO DIFFERENT OBJECTS UNDER THE SAME FORM ACTION.
		 */
		if(result.hasErrors()){
			return "askQuestion";
		}else{
			UserModel loggedInUser = (UserModel) session.getAttribute("current_user");//CASTS SESSION USER AS USER OBJECT

			if(loggedInUser!=null){
				question.setUser(loggedInUser);//IF USER IS NOT LOGGED IN, THEY WILL GET REDIRECTED TO REGISTRATION PAGE

				String[] tagArr = tags.split(","); //THE USER WILL PUT TAGS INTO THE INPUT, SEPARATED BY COMMAS. THIS LINE READS THE INPUT, ITEMIZES THE STRING BY SEPARATING IT INTO SMALLER STRINGS AS IT RUNS INTO COMMAS
				ArrayList<TagModel> tagArryList = new ArrayList<TagModel>(); //NEW ARRAYLIST BECAUSE THE NUMBER OF TAGS INPUT WILL VARY

				for(int i=0; i< tagArr.length; i++){ //WHILE i IS LESS THAN THE LENGTH OF TAGARR
					TagModel t = new TagModel();//BUILDS A BLANK OBJECT FOR A TAG
					t.setSubject(tagArr[i]); //BASICALLY STAGING THE TEXT FROM THE INPUT TO BE SAVED AS A TAG
					tagService.create(t);//SAVES TAG


					tagArryList.add( t ); //PUTS TAG OBJECTS INTO ARRAYLIST
				}

				question.setTag(tagArryList); //TAKES THE WHOLE ARRAYLIST FULL OF TAGS AND SETS IT IN THE MANY-TO-MANY TABLE ?
				questionService.create(question);//CREATES QUESTION

				return "redirect:/questions";
			}else{
				return "redirect:/register";
			}
		}
	}
	@RequestMapping("questions/ask/display/{id}")
	public String display(@PathVariable("id")long id, Model model){ //CAPTURING ID OF QUESTION, AND MAKING A BLANK MODEL
		QuestionModel question = questionService.findById(id);//DISPLAYING INDIVIDUAL SELECTED QUESTION BY THE ID FROM ABOVE
		ArrayList<QuestionModel> questionsAll = questionService.all(); //PRETTY SURE THIS ISNT DOING ANYTHING, CAUSE I DIDNT USE THE ARRAYLIST ANYWHERE, BUT ALSO TOO AFRAID TO DELETE
		List<AnswerModel> answers = question.getAnswer();//PUTTING LIST OF ANSWERS INTO A LIST
		model.addAttribute("question", question);
		model.addAttribute("a", new AnswerModel());//REASONABLY CERTAIN THIS ISNT DOING ANYTHING IMPORTANT ALSO
		model.addAttribute("answers",answers); //CALLING ANSWERS, WHICH SHOULD JUST BE THE CONTENT OF THE TAGS, NOTICE THIS HAS BEEN DONE IN THE CONTROLLER, AND NOT THE JSP, AS WS DONE IN THE QUESTIONS.JSP FOR QUESTIONS AND TAGS. THIS WAY IS MORE SECURE
		return "displayQuestion";

	}

	@PostMapping("questions/ask/display/{id}")
	public String answerFun(@Valid @ModelAttribute("a")AnswerModel answers, BindingResult result, HttpSession session, @PathVariable("id")long id){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(result.hasErrors()){
			return "displayQuestion"; //ERRORS STILL DO NOT DISPLAY CORRECTLY
		}else{
			QuestionModel qid = questionService.findById(id);	//CAPTURES ID OF QUESTION
			answers.setUser(loggedInUser);//SETS USER OBJECT INTO ANSWER OBJECT, SINCE THIS IS REQUIRED FOR ANSWER
			answers.setQuestion(qid);//SETS QUESTION OBJECT INTO ANSWER OBJECT, SINCE THIS IS REQUIRED FOR ANSWER
			AnswerModel test = new AnswerModel(answers.getQuestion(),answers.getUser(),answers.getAnswer());//THIS LINE IS BASICALLY DOING WHAT THE ABOVE TWO LINES ARE DOING, BUT ADDING THE INPUT TEXT FROM THE FORM ALSO.
			answerService.create(test);//SAVES THE NEW ANSWER OBJECT AND THROWS IT IN THE DATABASE

			return "redirect:/questions/ask/display/" + id;
		}
	}
}
