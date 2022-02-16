package com.fdmgroup.newspage.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fdmgroup.newspage.model.User;
import com.fdmgroup.newspage.repository.UserRepository;
import com.fdmgroup.newspage.service.UserService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserServiceTest {
	
	@MockBean
	UserRepository mockRepo;
	
	@InjectMocks
	UserService userService;
	
	@Test
	public void test_findAllUsers() {
		List<User> expectedList = new ArrayList<>();
		Mockito.when(mockRepo.findAll()).thenReturn(expectedList);
		userService.findAllUsers();
		verify(mockRepo).findAll();
	}
	
	@Test
	public void test_createUser() {
		List<User> expectedList = new ArrayList<>();	
		expectedList.add(new User("Mikolaj", "Szargut", "mik_szar", "1234", "1234", "mikolaj@gmail.com"));
		Mockito.when(mockRepo.save(expectedList.get(0))).thenReturn(expectedList.get(0));
		assertNotEquals(0, expectedList.size());
		assertEquals(expectedList.get(0).getPassword(), expectedList.get(0).getConfirmPassword());
		userService.createUser(expectedList.get(0));
		verify(mockRepo).save(expectedList.get(0));
	}
	


}
