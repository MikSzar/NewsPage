package com.fdmgroup.newspage.service;

import java.util.List;

import com.fdmgroup.newspage.model.News;

public interface INewsService {
	List<News> findAllNews();

	News findNewsById(Integer id);

	void createNews(News news);

	List<News> filterByName(String name);
	
	List<News> filterByImportant(int important);

	List<News> filterByAuthor(String author);
	
	List<News> filterByCountry(String country);

	List<News> filterByDescription(String description);

	void deleteNewsById(int id);
}
