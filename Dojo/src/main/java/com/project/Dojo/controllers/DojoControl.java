package com.project.Dojo.controllers;

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

import com.project.Dojo.models.DojoModel;
import com.project.Dojo.models.NinjaModel;
import com.project.Dojo.services.DojoService;
import com.project.Dojo.services.NinjaService;

@Controller
@RequestMapping("/dojo")
public class DojoControl{

	private DojoService dojoService;
	private NinjaService ninjaService;
	//Member variables go here

	public DojoControl(DojoService dojoService, NinjaService ninjaService){
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;

	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<DojoModel> dojos = dojoService.all();
		model.addAttribute("dojos", dojos); //MAKES DOJO OBJECTS CALLABLE ON JSP
		// System.out.println(dojos.get(0).getLocation());
		return "index";
	}

	@PostMapping("/addLocation")
	public String addLocation(@RequestParam(value="location") String location){ //REQUESTPARAM IS BASICALLY GRABBING POST INFO FROM THE JSP NAMED 'LOCATION' AND STORING IT IN A JAVA VARIABLE
		DojoModel dojo = new DojoModel(location); //AFOREMENTIONED JAVA VARAIBLE IS PLACED INSIDE OF THE THE DOJO CONSTRUCTOR, SO A NEW DOJO OBJECT CAN BE BUILT
		dojoService.create(dojo); //THIS LINE ACTUALLY BUILDS A NEW OBJECTS AND STORES IT IN DATABASE
		System.out.println(location);
		return "redirect:/dojo/";
	}	
	@RequestMapping("/dojoDisplay/{id}")
	public String dojoDisplay(@PathVariable("id") Long id, Model model){
		DojoModel dojoModel = dojoService.findById(id);
		List<NinjaModel> ninjas = dojoModel.getNinja(); //GETS NINJA OBJECTS THAT HAVE A DOJO_ID THAT MATCHES THE ACTUAL DOJO ID
		model.addAttribute("dojo", dojoModel); //MAKES DOJO OBJECTS CALLABLE ON JSP
		model.addAttribute("ninjas", ninjas); //MAKES NINJA OBJECTS CALLABLE ON JSP
		return "dojoDisplay";
	}
}
