package com.fdmgroup.newspage.service;

import java.util.List;

import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.model.News;

public interface ICategoriesService {

	List<Categories> findAllCategories();
	
	Categories findCategoriesById(Integer id);
	
	void createCategories(Categories categories);

	
	void deleteNewsFromCategories(Categories categories, News news);

}
