package com.project.Authentication.controllers;

import java.security.Principal;
import java.util.Calendar;
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

import com.project.Authentication.models.UserModel;
import com.project.Authentication.models.Bundle;
import com.project.Authentication.models.UserBundle;
import com.project.Authentication.repositories.*;
import com.project.Authentication.services.BundleService;
import com.project.Authentication.services.UserBundleService;
import com.project.Authentication.services.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserControl{
	//Member variables go here
	private UserService userService;
	private BCryptPasswordEncoder bcrypt;
	private BundleService bundleService;
	private UserBundleService userBundleService;

	public UserControl(UserService userService, BundleService bundleService, UserBundleService userBundleService){
		this.userService = userService;
		this.bcrypt = new BCryptPasswordEncoder();
		this.bundleService = bundleService;
		this.userBundleService = userBundleService;

	}

	@RequestMapping("adminDash")
	public String adminDash(HttpSession session, Model model, @ModelAttribute("bundle") Bundle bundle){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(loggedInUser != null && loggedInUser.isAdmin()){
			List<UserModel> users = userService.all();
			List<Bundle> bundles = bundleService.all();
			model.addAttribute("bundles", bundles);
			model.addAttribute("users", users);
			return "adminDash";
		}else{
			return "redirect:/errorPage";
		}

	}

	@RequestMapping("activity/{id}")
	public String activation(@PathVariable("id") long id, HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(session.getAttribute("current_user")!=null && loggedInUser.isAdmin()){
			Bundle bundle = bundleService.findById(id);
			if(bundle.isAvailable()==true){
				bundle.setAvailable(false);
				bundleService.update(bundle);
				return "redirect:/adminDash";
			}else{
				bundle.setAvailable(true);
				bundleService.update(bundle);
				return "redirect:/adminDash";
			}

		}else{
			return "redirect:/errorPage";
		}
	}

	@PostMapping("adminDash")
	public String createBundle(HttpSession session, Model model, @ModelAttribute("bundle")Bundle bundle, BindingResult result, @RequestParam("availble") boolean available){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(loggedInUser != null && loggedInUser.isAdmin()){
			bundle.setAvailable(available);
			bundleService.create(bundle);

			return "redirect:/adminDash";
		}else{
			return "redirect:/errorPage";
		}
	}

	@RequestMapping("/destroyB/{id}")
	public String destroyBundle(@PathVariable("id") long id){
		System.out.println(id + "*************************************************ID");
		bundleService.destroy(id);
		return "redirect:/adminDash";
	}

	@RequestMapping("dashboard")
	public String dashboard(HttpSession session, Model model,@ModelAttribute("buyBundle")UserBundle userBundle){
		if(session.getAttribute("current_user") !=null){
			List<Bundle> bundles = bundleService.all();
			model.addAttribute("bundles",bundles);
			return "dashboard";
		}else{
			return "redirect:/";
		}
	}

	@PostMapping("dashboard/subscribe")
	public String subscribe(UserBundle userBundle, @RequestParam("date") String date, @RequestParam("bundle")Bundle bundle, HttpSession session, BindingResult result, UserBundle userB){

		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		userB.setStartDate(date);
		long id = loggedInUser.getId();
		userBundleService.join(loggedInUser.getId(), bundle.getId());
		return "redirect:/profile/"+id+"/"+date+"/"+bundle.getName()+"/"+bundle.getCost();
	}

	@RequestMapping("profile/{id}/{date}/{bundleName}/{cost}")
	public String profile(Model model, @PathVariable("id") long id,@PathVariable("date") String date,@PathVariable("bundleName") String bundleName, @PathVariable("cost") String cost, HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("date", date);
		model.addAttribute("bundle", bundleName);
		model.addAttribute("cost",cost);
		return "test";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
		UserModel user = userService.findByEmail(email);

		if(user == null){
			return "redirect:/";
		}else if(user.isAdmin() && userService.isMatch(password, user.getPassword())){
			session.setAttribute("current_user", user);
			return "redirect:adminDash";
		}else{
			if(userService.isMatch(password, user.getPassword())){
				session.setAttribute("current_user", user);//STORES THE PERSON WHO JUST LOGGED IN INTO SESSION, THERE IS NOW NO NEED TO REACH BACK INTO SERVICES FOR LOGGED IN USER INFO
				return "redirect:/dashboard";
			}else{
				return "redirect:/register";

			}
		}
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") UserModel user, HttpSession session){
		session.setAttribute("current_user", null);
		return "register";
	}

	@PostMapping("/register")
	public String create(@Valid @ModelAttribute("user") UserModel user, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			return "register";
		}else{
			if(userService.all().size()==0){
				user.setAdmin(true);
			}
			userService.create(user);
			session.setAttribute("current_user", user);
		
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.setAttribute("current_user", null);
		return "redirect:/register";
	}


	/************************************CREATING, EDITING, DELETING USERS ***************************************************/

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id, HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(session.getAttribute("current_user")!=null && loggedInUser.isAdmin()){
			userService.destroy(id);
			return "redirect:/adminDash";
		}else{
			return "redirect:/errorPage";
		}
	}	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")long id, Model model, HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(session.getAttribute("current_user")!=null && loggedInUser.isAdmin()){
			UserModel user = userService.findById(id);
			model.addAttribute("user", user);
			System.out.println(user.getPassword());
			return "edit";
		}else{
			return "redirect:/errorPage";
		}
	}

	@RequestMapping("/adminDash/create")
	public String adminCreateForm(@ModelAttribute("user") UserModel user,HttpSession session){
		UserModel loggedInUser = (UserModel) session.getAttribute("current_user");
		if(session.getAttribute("current_user")!=null && loggedInUser.isAdmin()){
			return "adminCreate";
		}else{
			return "redirect:/errorPage";
		}
	}
	@PostMapping("/adminDash/create")
	public String adminCreateSubmit(@Valid @ModelAttribute("user") UserModel newUser, BindingResult result, @RequestParam ("admin") boolean admin){
		if(result.hasErrors()){
			return "adminCreate";
		}else{
			newUser.setAdmin(admin);
			userService.create(newUser);
			System.out.println("test");
			return "redirect:/adminDash";
	}
}
	@PostMapping("/edit/{id}/update")
	public String update(
		@PathVariable("id") long id,
		@RequestParam("firstName") String firstName, 
		@RequestParam("lastName") String lastName, 
		@RequestParam("email")String email,
		@RequestParam("admin") boolean admin
		){
		UserModel user = userService.findById(id);
		System.out.println(user.getPassword());
		user.setAdmin(admin);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		// String password = user.getPassword();
		System.out.println("BEFORE PASSWORD");
		user.setPassword(user.getPassword());
		System.out.println("AFTER PASSWORD");
		userService.update(user);
		return "redirect:/adminDash";
	}
}

