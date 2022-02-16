package com.fdmgroup.newspage.service.test;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.newspage.model.News;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fdmgroup.newspage.repository.NewsRepository;
import com.fdmgroup.newspage.service.NewsService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class NewsServiceTest {

	@MockBean
    NewsRepository mockRepo;
	
	@InjectMocks
    NewsService newsService;
	
	@Test
	public void test_findAllNews() {
		List<News> expectedList = new ArrayList<>();
		Mockito.when(mockRepo.findAll()).thenReturn(expectedList);
		newsService.findAllNews();
		verify(mockRepo).findAll();
	}
	
	@Test
	public void test_findNewsById() {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		news.setId(10);
		newsService.findNewsById(news.getId());
		verify(mockRepo).findById(news.getId());
	}
	
	@Test
	public void test_createNews() {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		Mockito.when(mockRepo.save(news)).thenReturn(news);
		newsService.createNews(news);
		verify(mockRepo).save(news);
	}
	
	@Test
	public void test_filterByName() {
		List<News> expectedList = new ArrayList<>();
		expectedList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		String name = "Political problems";
		Mockito.when(mockRepo.findByNameContains(name)).thenReturn(expectedList);
		newsService.filterByName(name);
		verify(mockRepo).findByNameContains(name);
	}
	
	@Test
	public void test_filterByAuthor() {
		List<News> expectedList = new ArrayList<>();
		expectedList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		String author = "Mikolaj Szargut";
		Mockito.when(mockRepo.filterByAuthor(author)).thenReturn(expectedList);
		newsService.filterByAuthor(author);
		verify(mockRepo).filterByAuthor(author);
	}
	
	@Test
	public void test_deleteNewsById() {
		List<News> expectedList = new ArrayList<>();
		expectedList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		news.setId(8);
		Mockito.verify(mockRepo).delete(news);
	}
	
	@Test
	public void test_filterByCountry() {
		List<News> expectedList = new ArrayList<>();
		expectedList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		String country = "Poland";
		Mockito.when(mockRepo.filterByCountry(country)).thenReturn(expectedList);
		newsService.filterByCountry(country);
		verify(mockRepo).filterByCountry(country);
	}

	
	@Test
	public void test_filterByImportant() {
		List<News> expectedList = new ArrayList<>();
		expectedList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		int important = 7;
		Mockito.when(mockRepo.filterByImportant(important)).thenReturn(expectedList);
		newsService.filterByImportant(important);
		verify(mockRepo).filterByImportant(important);
	}
	
}
