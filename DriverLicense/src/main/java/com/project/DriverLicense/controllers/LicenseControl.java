package com.project.DriverLicense.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

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

import com.project.DriverLicense.models.*;
import com.project.DriverLicense.repositories.*;
import com.project.DriverLicense.services.*;

@Controller
@RequestMapping("/license")
public class LicenseControl{

	private LicenseService licenseService;
	private PersonService personService;
	//Member variables go here

	public LicenseControl(LicenseService licenseService, PersonService personService){
		this.licenseService = licenseService;
		this.personService = personService;

	}
	
	@RequestMapping("/newLicense")
	public String index(Model model){
		ArrayList<Person> people = personService.all();
		model.addAttribute("people", people);
		return "newLicense";
	}

	@PostMapping("/createLicense")
	public String createLicense(
		@RequestParam(value="human") Person person,
		@RequestParam(value="state") String state

	){

		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE, 3000);

		String number = licenseService.generateNumber();
		License license = new License(state, person, cal.getTime(), number);
		licenseService.create(license);
		return "redirect:displayLicense/" + license.getId();
	}

	@RequestMapping("/displayLicense/{id}")
	public String displayLicense(
		@PathVariable("id") Long id,
		// @PathVariable("person") long person,
		Model model
	){
		License license = licenseService.findById(id);
		model.addAttribute("license", license);
		model.addAttribute("person", license.getPerson());
		return "licenseDisplay";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
