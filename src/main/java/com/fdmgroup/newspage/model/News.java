package com.fdmgroup.newspage.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class News {
	
	@Id
	@GeneratedValue
	private Integer id;

	private int important;
	private String name, author, country, imageurl, description;
	public News() {}

	public News(String name, int important, String author, String country, String description) {
		super();
		this.important = important;
		this.name = name;
		this.author = author;
		this.country = country;
		this.description = description;
	}
	
	public News(Integer id, String name, int important, String author, String country, String description) {
		super();
		this.id = id;
		this.important = important;
		this.name = name;
		this.author = author;
		this.country = country;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getImportant() {
		return important;
	}

	public void setImportant(int important) {
		if (important < 1 || important > 10) {
			throw new IllegalArgumentException(important + " is not a valid number. Importance must be between 1 and 10 inclusive");
		}
		this.important = important;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(important, author, country, id, imageurl, name, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return important == other.important && Objects.equals(author, other.author) && Objects.equals(country, other.country)
				&& Objects.equals(id, other.id) && Objects.equals(imageurl, other.imageurl)
				&& Objects.equals(name, other.name) && Objects.equals(description, other.description);

	}

	@Override
	public String toString() {
		return "News [id=" + id + ", important=" + important + ", name=" + name + ", author=" + author + ", country=" + country
				+ ", imageurl=" + imageurl + ", description=" + description + "]";
	}
	
	
	
}
