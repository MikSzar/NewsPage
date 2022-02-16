package com.fdmgroup.newspage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fdmgroup.newspage.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer>{
	
	@Query("SELECT p FROM Plan p where p.catid = ?1")
	List<Plan> filterByCategoryID(int catid);
	
	@Query("SELECT p FROM Plan p where p.catid = ?1 AND p.newsid = ?2")
	List<Plan> filterByCatidAndNewsid(int catid, int newsid);

}
