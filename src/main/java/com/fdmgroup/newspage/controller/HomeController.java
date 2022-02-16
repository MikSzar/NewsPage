package com.fdmgroup.newspage.controller;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.newspage.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.newspage.exception.NewsNotFoundException;
import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.service.ICategoriesService;
import com.fdmgroup.newspage.service.INewsService;
import com.fdmgroup.newspage.service.IPlanService;

@Controller
public class HomeController {

	@Autowired
	INewsService newsService;

	@Autowired
	ICategoriesService categoriesService;

	@Autowired
	IPlanService planService;

	@GetMapping("/")
	public String goToHome(ModelMap model) {
		populateModelNews(model);
		populateModelCategories(model);
		populateModelPlan(model);
		return "home";
	}

	@PostMapping("/")
	public String createNewNews(ModelMap model, @ModelAttribute News news) {
		newsService.createNews(news);
		populateModelNews(model);
		return "home";
	}

	/*@PostMapping("/deleteFromPlan")
	public String deleteToPlan(ModelMap model, @RequestParam Categories categories, @RequestParam News news) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		planService.filterByCatidAndDid(categories.getCatid(), news.getId());
		planService.deletePlan(planService.filterByCatidAndDid(categories.getCatid(), news.getId()).get(0).getPid());
		return "home";
	}*/
	
	
	@PostMapping("/FilterCategories")
	public String FilterCategories(ModelMap model, @RequestParam Categories categories) {
		populateModelCategories(model);
		populateModelNews(model);
		populateModelPlan(model);
		List<News> newsList = new ArrayList<News>();
		for(int i = 0; i < planService.findPlanbyCategoryId(categories.getCatid()).size(); i++) {
			newsList.add(newsService.findNewsById(planService.findPlanbyCategoryId(categories.getCatid()).get(i).getNewsid()));
		}
		model.addAttribute("newsPlan", newsList);
		return "home"; 
	}

	@GetMapping("details/{id}")
	public String goToDetails(ModelMap model, @PathVariable Integer id) {
		News news = newsService.findNewsById(id);
		model.addAttribute("news", news);
		return "details";
	}

	@PostMapping("/filtered/name")
	public String filterByName(ModelMap model, @RequestParam String name) {
		populateModelNews(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByName(name);
		model.addAttribute("filteredNews", filteredList);
		return "home";
	}

	@PostMapping("/filtered/important")
	public String filterByImportant(ModelMap model, @RequestParam int important) {
		populateModelNews(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByImportant(important);
		model.addAttribute("filteredNews", filteredList);
		return "home";
	}

	@PostMapping("/filtered/author")
	public String filterByAuthor(ModelMap model, @RequestParam String author) {
		populateModelNews(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByAuthor(author);
		model.addAttribute("filteredNews", filteredList);
		return "home";
	}

	@PostMapping("/filtered/country")
	public String filterByCountry(ModelMap model, @RequestParam String country) {
		populateModelNews(model);
		List<News> filteredList = new ArrayList<>();
		filteredList = newsService.filterByCountry(country);
		model.addAttribute("filteredNews", filteredList);
		return "home";
	}

	@PostMapping("/searchProduct")
	public String searchBarfilterNews(ModelMap model, @RequestParam String description) {
		populateModelCategories(model);
		populateModelNews(model);
		List<News> filteredlist = newsService.filterByDescription(description);
		model.addAttribute("filteredNews", filteredlist);
		return "home";
	}

	@ExceptionHandler(NewsNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView NewsNotFound(NewsNotFoundException ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", ex.getMessage());
		modelAndView.setViewName("newsNotFound");
		return modelAndView;
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
