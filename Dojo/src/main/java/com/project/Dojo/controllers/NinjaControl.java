package com.project.Dojo.controllers;

import com.project.Dojo.models.DojoModel;
import com.project.Dojo.models.NinjaModel;
import com.project.Dojo.services.DojoService;
import com.project.Dojo.services.NinjaService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;

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

@Controller
@RequestMapping("/ninjas")
public class NinjaControl{

	private NinjaService ninjaService;
	private DojoService dojoService;
	//Member variables go here

	public NinjaControl(NinjaService ninjaService, DojoService dojoService){
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/addNinja")
	public String addNinja(Model model){
		ArrayList<DojoModel> dojos = dojoService.all();
		model.addAttribute("dojos", dojos);
		return "ninjas";
	}
	
	@PostMapping("/createNinja")
	public String createNinja(
		@RequestParam(value="dojo") DojoModel location,
		@RequestParam(value="firstName") String firstName,
		@RequestParam(value="lastName") String lastName,
		@RequestParam(value ="age") int age
		){
			NinjaModel ninja = new NinjaModel(location, firstName, lastName, age);
			ninjaService.create(ninja);
			System.out.println(location+firstName+lastName+age);
			return "redirect:addNinja";
		}
	
		@RequestMapping("/dashboard")
		public String dashboard(Model model){
			// NinjaModel ninjaTest = ninjaService.findById(id);
			ArrayList<NinjaModel> ninjas = ninjaService.all();
			model.addAttribute("ninjas", ninjas);
			// model.addAttribute("dojos", ninjaTest.getDojo());
			return "dashboard";
		}
}
