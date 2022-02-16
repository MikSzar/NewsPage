package com.fdmgroup.newspage.repository;

import java.util.List;

import com.fdmgroup.newspage.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

	List<News> findByNameContains(String name);

	List<News> findByDescriptionContains(String description);

	@Query("SELECT n FROM News n where n.author LIKE %?1%")
	List<News> filterByAuthor(String author);
	
	@Query("SELECT n FROM News n where n.country LIKE %?1%")
	List<News> filterByCountry(String country);
	
	@Query("SELECT n FROM News n where n.important < ?1")
	List<News> filterByImportant(int important);

}
