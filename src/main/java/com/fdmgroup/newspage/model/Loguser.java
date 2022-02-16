package com.fdmgroup.newspage.model;

public class Loguser {

	private Integer id = null;
	private String username = "Guest";

	public Loguser() {}

	public Loguser(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "LoggedUser [id=" + id + ", username=" + username + "]";
	}




}
