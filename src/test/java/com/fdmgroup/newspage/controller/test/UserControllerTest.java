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

import com.fdmgroup.newspage.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroup.newspage.controller.UserController;
import com.fdmgroup.newspage.model.Categories;
import com.fdmgroup.newspage.service.ICategoriesService;
import com.fdmgroup.newspage.service.INewsService;
import com.fdmgroup.newspage.service.IPlanService;
import com.fdmgroup.newspage.service.IUserService;

@SpringBootTest(classes = { UserController.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@MockBean
	private INewsService newsService;

	@MockBean
	private ICategoriesService categoriesService;

	@MockBean
	private IPlanService planService;
	
	@MockBean
	private IUserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void test_goToUserRegistrationPage_statusOk() throws Exception {
		List<News> expectedNewsList = new ArrayList<>();
		expectedNewsList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		List<Categories> expectedCategoriesList = new ArrayList<>();
		expectedCategoriesList.add(new Categories(7, "title", "description"));
		List<Plan> expectedPlanList = new ArrayList<>();
		expectedPlanList.add(new Plan(1, 50));
		when(newsService.findAllNews()).thenReturn(expectedNewsList);
		when(categoriesService.findAllCategories()).thenReturn(expectedCategoriesList);
		when(planService.findAllPlans()).thenReturn(expectedPlanList);
		
		mockMvc.perform(get("/registration")).andExpect(status().isOk())
				.andExpect(model().attribute("news", expectedNewsList))
				.andExpect(model().attribute("categories", expectedCategoriesList))
				.andExpect(model().attribute("plan", expectedPlanList)).andExpect(view().name("userRegistration"));
	}
	
	@Test
	public void test_registrateNewUser() throws Exception {
		User user = new User("Mikolaj", "Szargut", "mik_szar", "1234", "1234", "mikolaj@gmail.com");
		user.setId(1);
		mockMvc.perform(post("/registration").param("firstName", "Mikolaj").param("lastName", "Szargut")
		.param("username", "mik_szar").param("password", "1234").param("confirmPassword", "1234").param("email", "mikolaj@gmail.com"))
				.andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(userService).createUser(user);
				
	}
	
	@Test
	public void test_goToUserLogin_statusOk() throws Exception {
		List<News> expectedNewsList = new ArrayList<>();
		expectedNewsList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		List<Categories> expectedCategoriesList = new ArrayList<>();
		expectedCategoriesList.add(new Categories(7, "title", "description"));
		List<Plan> expectedPlanList = new ArrayList<>();
		expectedPlanList.add(new Plan(1, 50));
		when(newsService.findAllNews()).thenReturn(expectedNewsList);
		when(categoriesService.findAllCategories()).thenReturn(expectedCategoriesList);
		when(planService.findAllPlans()).thenReturn(expectedPlanList);
		
		mockMvc.perform(get("/login")).andExpect(status().isOk())
				.andExpect(model().attribute("news", expectedNewsList))
				.andExpect(model().attribute("categories", expectedCategoriesList))
				.andExpect(model().attribute("plan", expectedPlanList)).andExpect(view().name("userLogin"));
	}
	
	@Test
	public void test_loginUser() throws Exception {
		User user = new User("Mikolaj", "Szargut", "mikszar", "1234", "1234", "mikolaj@gmail.com");
		user.setId(4);
		mockMvc.perform(post("/login").param("firstName", "Mikolaj").param("lastName", "Szargut")
		.param("username", "mikszar").param("password", "1234").param("confirmPassword", "1234").param("email", "mikolaj@gmail.com"))
				.andExpect(status().isOk())
				.andExpect(view().name("database"));
		verify(userService, times(1)).findByUsernamePassword(user.getUsername(), user.getPassword());		
	}
	
	@Test
	public void test_goToHomepage_statusOk() throws Exception {
		List<News> expectedNewsList = new ArrayList<>();
		expectedNewsList.add(new News("Political problems", 7, "Mikolaj Szargut", "Poland", "The great scandal was published yesterday"));
		List<Categories> expectedCategoriesList = new ArrayList<>();
		expectedCategoriesList.add(new Categories(7, "title", "description"));
		List<Plan> expectedPlanList = new ArrayList<>();
		expectedPlanList.add(new Plan(1, 50));
		when(newsService.findAllNews()).thenReturn(expectedNewsList);
		when(categoriesService.findAllCategories()).thenReturn(expectedCategoriesList);
		when(planService.findAllPlans()).thenReturn(expectedPlanList);
		
		mockMvc.perform(get("/newsDatabase")).andExpect(status().isOk())
				.andExpect(model().attribute("news", expectedNewsList))
				.andExpect(model().attribute("categories", expectedCategoriesList))
				.andExpect(model().attribute("plan", expectedPlanList)).andExpect(view().name("home"));
	}
	
}
