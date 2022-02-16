package com.fdmgroup.newspage.service;

import java.util.List;

import com.fdmgroup.newspage.model.Plan;

public interface IPlanService {
	
	List<Plan> findAllPlans();
	
	Plan findPlanById(Integer pid);
	
	List<Plan> findPlanbyCategoryId(int catid);
	
	List<Plan> filterByCatidAndDid(int catid, int newsid);
	
	void createPlan(Plan plan);
	
	void deletePlan(int pid);
	
	
	

}
