package com.project.DriverLicense.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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

import com.project.DriverLicense.models.Person;
import com.project.DriverLicense.services.PersonService;


@Controller
@RequestMapping("/person")
public class PersonControl{
	//Member variables go here
	private PersonService personService;


	public PersonControl(PersonService personService){
		this.personService = personService;

	}
	
	@RequestMapping("/new")
	public String index(){
		return "newPerson";
	}

	@PostMapping("/createPerson")
	public String createPerson(
		@RequestParam(value="firstName") String firstName,
		@RequestParam(value="lastName") String lastName,
		Model model
		
		){
		
			Person person = new Person(firstName, lastName);
			personService.create(person);
			System.out.println(person.getFirstName()+ " " + person.getLastName()+ " has been created");
			return "redirect:/license/newLicense";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/";
	}		
}
