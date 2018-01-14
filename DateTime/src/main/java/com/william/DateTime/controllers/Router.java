package com.william.DateTime.controllers;

import java.security.Principal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	public Router(){

	}

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/kittycatlicklick")
	public String date(Model model){
		DateFormat day = new SimpleDateFormat("E");
		DateFormat dayNum = new SimpleDateFormat("dd");
		DateFormat month = new SimpleDateFormat("MMMM");
		DateFormat year = new SimpleDateFormat("yyyy");
		Date dateobj = new Date();
		model.addAttribute("date", day.format(dateobj) + ", the " + dayNum.format(dateobj) + " of " + month.format(dateobj) + ", " + year.format(dateobj));
		return "date";
	}


	@RequestMapping("/time")
	public String time(Model model){
		DateFormat time = new SimpleDateFormat("hh:mm a");
		Date dateobj = new Date();
		model.addAttribute("date", time.format(dateobj));
		return "time";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
