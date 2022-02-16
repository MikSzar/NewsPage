package com.fdmgroup.newspage.service.test;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.newspage.model.Categories;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fdmgroup.newspage.repository.CategoriesRepository;
import com.fdmgroup.newspage.service.CategoriesService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoriesServiceTest {

	@MockBean
    CategoriesRepository mockRepo;
	
	@InjectMocks
    CategoriesService categoriesService;
	
	@Test
	public void test_findAllNews() {
		List<Categories> expectedList = new ArrayList<>();
		Mockito.when(mockRepo.findAll()).thenReturn(expectedList);
		
		categoriesService.findAllCategories();
		
		verify(mockRepo).findAll();
	}
	
	@Test
	public void test_findCategoriesById() {
		Categories categories = new Categories(7,"Title", "Description");
		
		categoriesService.findCategoriesById(categories.getCatid());
			
		verify(mockRepo).findById(categories.getCatid());
	}
	
	@Test
	public void test_createCategories() {
		Categories categories = new Categories(7,"Title", "Description");

		Mockito.when(mockRepo.save(categories)).thenReturn(categories);
		
		categoriesService.createCategories(categories);
		
		verify(mockRepo).save(categories);
	}
	
}
