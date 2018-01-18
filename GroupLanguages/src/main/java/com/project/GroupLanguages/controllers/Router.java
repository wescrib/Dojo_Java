/**
 * Authors: William, Kapiolani, Ricardo
 * 17JAN2018
 * Build a webapp where you can basically build objects, display them, edit, delete, and display a page with more info on said objects.
 */

package com.project.GroupLanguages.controllers;

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
import com.project.GroupLanguages.models.*;
import com.project.GroupLanguages.services.*;

@Controller
@RequestMapping("/*") // Wildcard all routes.
public class Router{
	private LanguageService languageService;

	public Router(LanguageService languageService){
		this.languageService = languageService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("language") Languages language, Model model){
		ArrayList<Languages>languages = languageService.all();
		model.addAttribute("languages", languages);
		return "index";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id){
		languageService.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model){
		Languages language = languageService.findById(id);
		model.addAttribute("language", language);
		return "/edit";
	}

	@PostMapping("/update/{id}")
	//path variable captures id of objects, language objects allows user to edit specific object
	public String update(@PathVariable("id") long id, Languages language){
		// Languages language = new Languages(name,creator, version);
		// languageService.edit(language);
		System.out.println(id);
		languageService.edit(language);

		return "redirect:/";
	}

	@PostMapping("/kittykatlicklick")
	public String createLanguage(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version") double version){
		Languages language = new Languages(name, creator, version);
		// language.setName(name);
		// language.setCreator(creator);
		// language.setVersion(version);
		languageService.create(language);
		return "redirect:/";
		// return "edit";
	}

	@RequestMapping("/info/{id}")
	public String info(@PathVariable("id") long id, Model model){
		// ArrayList<Languages>languages = languageService.all();
		Languages language = languageService.findById(id);
		model.addAttribute("languages", language);
		return "info";
	}

	@RequestMapping("")
	public String redirect(HttpServletRequest req){		
		String url = req.getRequestURI().toString();
		return "redirect:/index";
	}		
}
