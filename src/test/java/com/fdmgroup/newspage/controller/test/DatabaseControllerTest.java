package com.fdmgroup.newspage.controller.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.model.News;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.newspage.controller.DatabaseController;
import com.fdmgroup.newspage.model.Plan;
import com.fdmgroup.newspage.service.ICategoriesService;
import com.fdmgroup.newspage.service.INewsService;
import com.fdmgroup.newspage.service.IPlanService;

@SpringBootTest(classes = { DatabaseController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DatabaseControllerTest {

	@MockBean
	private INewsService newsService;

	@MockBean
	private ICategoriesService categoriesService;

	@MockBean
	private IPlanService planService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_goToNewsDatabasePage_statusOk() throws Exception {
		List<News> expectedNewsList = new ArrayList<>();
		expectedNewsList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		List<Plan> expectedPlanList = new ArrayList<>();
		expectedPlanList.add(new Plan(1, 50));
		when(newsService.findAllNews()).thenReturn(expectedNewsList);
		when(planService.findAllPlans()).thenReturn(expectedPlanList);
		mockMvc.perform(get("/listNews")).andExpect(status().isOk())
				.andExpect(model().attribute("news", expectedNewsList))
				.andExpect(model().attribute("plan", expectedPlanList)).andExpect(view().name("database"));
	}

	@Test
	public void test_createNewNews() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		mockMvc.perform(post("/listNews").param("name", "Political problems").param("important", "7").param("author", "Mikolaj Szargut").param("description", "The great scandal was published yesterday")
				.param("country", "Poland")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).createNews(news);
	}

	@Test
	public void test_deleteNews() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		news.setId(10);
		mockMvc.perform(post("/deleteNews").param("id", "10")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).deleteNewsById(news.getId());
	}

	@Test
	public void test_filterByName() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		mockMvc.perform(post("/listNews/filtered/name").param("name", "Political problems")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).filterByName(news.getName());
	}

	@Test
	public void test_filterByImportant() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		mockMvc.perform(post("/listNews/filtered/important").param("important", "7")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).filterByImportant(news.getImportant());
	}

	@Test
	public void test_filterByAuthor() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		mockMvc.perform(post("/listNews/filtered/author").param("author", "Mikolaj Szargut")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).filterByAuthor(news.getAuthor());
	}

	@Test
	public void test_filterByCountry() throws Exception {
		News news = new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday");
		mockMvc.perform(post("/listNews/filtered/country").param("country", "Poland")).andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(newsService, times(1)).filterByCountry(news.getCountry());
	}

}
