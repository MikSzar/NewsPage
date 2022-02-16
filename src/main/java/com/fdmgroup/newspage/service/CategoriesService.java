package com.fdmgroup.newspage.service;

import java.util.List;
import java.util.Optional;

import com.fdmgroup.newspage.exception.NewsNotFoundException;
import com.fdmgroup.newspage.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.repository.CategoriesRepository;
import com.fdmgroup.newspage.repository.NewsRepository;

@Service
public class CategoriesService extends NewsService implements ICategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private NewsRepository newsRepository;

	@Autowired
	private NewsService newsService;

	@Override
	public List<Categories> findAllCategories() {
		return categoriesRepository.findAll();
	}

	@Override
	public Categories findCategoriesById(Integer id) {
		Optional<Categories> optCategories = categoriesRepository.findById(id);
		if (optCategories.isPresent())
			return optCategories.get();
		else
			throw new NewsNotFoundException(id);
	}
	
	@Override
	public void createCategories(Categories categories) {
		categoriesRepository.save(categories);
	}

	
	@Override
	public void deleteNewsFromCategories(Categories categories, News news) {

	}

}
