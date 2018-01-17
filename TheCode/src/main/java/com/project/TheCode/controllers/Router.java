package com.project.TheCode.controllers;

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
	public String index(@ModelAttribute("errors") String errors){
		System.out.println(errors);
		return "index";
	}

	@PostMapping(path="/process")
	public String process(@RequestParam(value = "code") String code, HttpSession session){
		session.setAttribute("code", code);
		System.out.println(session.getAttribute("code"));
		String correct = "bushido";
		if(session.getAttribute("code").equals(correct)){
			System.out.println("ITS GETTING TO THE IF STATEMENT");
			return "/code";
		} else {
			System.out.println("Its getting at least this far");
			return "redirect:/errors";
		}
		// return "redirect:/code";
	}

	@RequestMapping("/code")
	public String code(){
		return "code";
	}

	@RequestMapping("/errors")
	public String errors(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("errors","You must train harder!");
		return "redirect:/";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
