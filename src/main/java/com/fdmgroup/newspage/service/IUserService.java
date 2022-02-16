package com.fdmgroup.newspage.service;

import java.util.List;

import com.fdmgroup.newspage.model.User;

public interface IUserService {
	
	List<User> findAllUsers();
	
	boolean createUser(User user);
	
	User findByUsernamePassword(String username, String password);
	

}
