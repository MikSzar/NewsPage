package com.fdmgroup.newspage.service;

import java.util.List;
import java.util.Optional;

import com.fdmgroup.newspage.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.newspage.exception.NewsNotFoundException;
import com.fdmgroup.newspage.repository.NewsRepository;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository repo;
	
	@Override
	public List<News> findAllNews() {
		return repo.findAll();
	}

	@Override
	public News findNewsById(Integer id) {
		Optional<News> optNews = repo.findById(id);
		if (optNews.isPresent())
			return optNews.get();
		else
			throw new NewsNotFoundException(id);
	}

	@Override
	public void createNews(News news) {
		repo.save(news);
	}

	@Override
	public List<News> filterByName(String name) {
		return repo.findByNameContains(name);
	}

	@Override
	public List<News> filterByDescription(String description) {
		return repo.findByDescriptionContains(description);
	}

	@Override
	public List<News> filterByAuthor(String author) {
		return repo.filterByAuthor(author);
	}

	@Override
	public void deleteNewsById(int id) {
		repo.delete(findNewsById(id));
	}

	@Override
	public List<News> filterByCountry(String country) {
		return repo.filterByCountry(country);
	}

	@Override
	public List<News> filterByImportant(int important) {
		return repo.filterByImportant(important);
	}
}
