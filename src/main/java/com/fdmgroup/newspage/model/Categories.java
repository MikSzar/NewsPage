package com.fdmgroup.newspage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categories {
	
	@Id
	private Integer catid;
	
	private String title; 
	
	@Column(length = 300)
	private String description;
	
	public Categories() {}

	public Categories(Integer catid, String title, String description) {
		super();
		this.catid = catid;
		this.title = title;
		this.description = description;
	}
	
	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

		
}


