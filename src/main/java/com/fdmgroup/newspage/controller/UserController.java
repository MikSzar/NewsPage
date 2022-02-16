package com.fdmgroup.newspage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.newspage.model.Loguser;
import com.fdmgroup.newspage.model.User;
import com.fdmgroup.newspage.service.ICategoriesService;
import com.fdmgroup.newspage.service.INewsService;
import com.fdmgroup.newspage.service.IPlanService;
import com.fdmgroup.newspage.service.IUserService;

@Controller
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	INewsService newsService;

	@Autowired
    ICategoriesService categoriesService;

	@Autowired
	IPlanService planService;
	
	
	@GetMapping("/registration")
	public String goToUserRegistrationPage(ModelMap model) {
		populateModelNews(model);
		populateModelCategories(model);
		populateModelPlan(model);
		return "userRegistration";
	}

	@PostMapping("/registration")
	public String registrateNewUser(ModelMap model, @ModelAttribute User user) {
		Loguser loguser = new Loguser();
		String jspFile = "newsNotFound";
		if (userService.createUser(user)) {
			loguser.setId(user.getId());
			loguser.setUsername(user.getUsername());
			model.addAttribute("loguser", loguser);
			populateModelNews(model);
			populateModelCategories(model);
			populateModelPlan(model);
			userService.createUser(user);
			return "database";
		} else {
			return "userNotFound";
		}
	}

	@GetMapping("/login")
	public String goToUserLogin(ModelMap model) {
		populateModelNews(model);
		populateModelCategories(model);
		populateModelPlan(model);
		return "userLogin";
	}

	@PostMapping("/login")
	public String loginUser(ModelMap model, @RequestParam String username, @RequestParam String password) {
		Loguser loguser = new Loguser();
		if (userService.findByUsernamePassword(username, password) != null) {
			loguser.setId(userService.findByUsernamePassword(username, password).getId());
			loguser.setUsername(username);
			model.addAttribute("loguser", loguser);
			populateModelNews(model);
			populateModelCategories(model);
			populateModelPlan(model);
			return "database";
		} else {
			return "userNotFound"; 
		}
	}
	
	@GetMapping("/newsDatabase")
	public String goToHomepage(ModelMap model) {
		populateModelNews(model);
		populateModelCategories(model);
		populateModelPlan(model);
		return "home";
	}
	
	private void populateModelNews(ModelMap model) {
		model.addAttribute("news", newsService.findAllNews());
	}

	private void populateModelCategories(ModelMap model) {
		model.addAttribute("categories", categoriesService.findAllCategories());
	}

	private void populateModelPlan(ModelMap model) {
		model.addAttribute("plan", planService.findAllPlans());
	}
	

}
