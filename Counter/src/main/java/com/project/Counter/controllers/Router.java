package com.project.Counter.controllers;

import java.security.Principal;
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
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	public Router(){

	}

	@RequestMapping("/")
	public String index(HttpSession session){
		if(session.getAttribute("count")==null){ //sets up a session variable called "count"
			session.setAttribute("count",0); //sets intial session count to 0
		}else{
			session.setAttribute("count",(Integer) session.getAttribute("count")+1); //casts count as an INT datatype and adds 1 to the "count"
		}
		return "index";
	}

	@RequestMapping("/counter")
	public String counter(){

		return "counter";
	}

	@RequestMapping("/bonusCounter")
	public String bonusCounter(HttpSession session){
		if(session.getAttribute("countB")==null){ //sets up a session variable called "count"
			session.setAttribute("countB",0); //sets intial session count to 0
		}else{
			session.setAttribute("countB",(Integer) session.getAttribute("countB")+2); //casts count as an INT datatype and adds 1 to the "count"
		}
		return "bonusCounter";
	}

	@RequestMapping("/reset")
	public String reset(HttpSession session){
		session.setAttribute("count", 0);
		return "redirect:/";
	}

	@RequestMapping("/resetB")
	public String resetB(HttpSession session){
		session.setAttribute("countB", 0);
		return "redirect:/bonusCounter";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
