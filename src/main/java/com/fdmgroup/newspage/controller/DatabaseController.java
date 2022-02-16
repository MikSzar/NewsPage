package com.fdmgroup.newspage.controller;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.newspage.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.model.Plan;
import com.fdmgroup.newspage.service.ICategoriesService;
import com.fdmgroup.newspage.service.INewsService;
import com.fdmgroup.newspage.service.IPlanService;

@Controller
public class DatabaseController {

	@Autowired
	INewsService newsService;

	@Autowired
	ICategoriesService categoriesService;

	@Autowired
	IPlanService planService;
	
	@GetMapping("/listNews")
	public String goToNewsDatabasePage(ModelMap model) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		return "database";
	}
	
	@PostMapping("/listNews")
	public String createNewNews(ModelMap model, @ModelAttribute News news) {
		newsService.createNews(news);
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		return "database";
	}
	
	@PostMapping("/deleteNews")
	public String deleteNews(ModelMap model, @RequestParam int id) {
		newsService.deleteNewsById(id);
		populateModelNews(model);
		populateModelPlan(model);
		return "database";
	}   
	
	@PostMapping("/listNews/filtered/name")
	public String filterByName(ModelMap model, @RequestParam String name) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByName(name);
		model.addAttribute("filteredNews", filteredList);
		return "database";
	}
	
	@PostMapping("/listNews/filtered/important")
	public String filterByImportant(ModelMap model, @RequestParam int important) {
		populateModelNews(model);
		populateModelPlan(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByImportant(important);
		model.addAttribute("filteredNews", filteredList);
		return "database";
	}
	
	@PostMapping("/listNews/filtered/author")
	public String filterByAuthor(ModelMap model, @RequestParam String author) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByAuthor(author);
		model.addAttribute("filteredNews", filteredList);
		return "database";
	}
	
	@PostMapping("/listNews/filtered/country")
	public String filterByCountry(ModelMap model, @RequestParam String country) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByCountry(country);
		model.addAttribute("filteredNews", filteredList);
		return "database";
	}

	
	@PostMapping("/addToPlan")
	public String addToPlan(ModelMap model, @RequestParam Categories categories, @RequestParam News news) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		Plan plan = new Plan(categories.getCatid(), news.getId());
		planService.createPlan(plan);
		return "database";
	}

	@PostMapping("/deleteFromPlan")
	public String deleteToPlan(ModelMap model, @RequestParam Categories categories, @RequestParam News news) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		planService.filterByCatidAndDid(categories.getCatid(), news.getId());
		planService.deletePlan(planService.filterByCatidAndDid(categories.getCatid(), news.getId()).get(0).getPid());
		return "database";
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
