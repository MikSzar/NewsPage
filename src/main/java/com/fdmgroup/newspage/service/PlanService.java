package com.fdmgroup.newspage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.newspage.exception.NewsNotFoundException;
import com.fdmgroup.newspage.model.Plan;
import com.fdmgroup.newspage.repository.CategoriesRepository;
import com.fdmgroup.newspage.repository.NewsRepository;
import com.fdmgroup.newspage.repository.PlanRepository;

@Service
public class PlanService implements IPlanService {

	@Autowired
	private PlanRepository planRepo;

	@Autowired
	private NewsRepository dogRepo;

	@Autowired
	private CategoriesRepository activityRepo;

	@Override
	public List<Plan> findAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan findPlanById(Integer pid) {
		Optional<Plan> optPlan = planRepo.findById(pid);
		if (optPlan.isPresent())
			return optPlan.get();
		else
			throw new NewsNotFoundException(pid);
	}

	@Override
	public void createPlan(Plan plan) {
		planRepo.save(plan);
	}

	@Override
	public void deletePlan(int pid) {
		planRepo.delete(findPlanById(pid));
	}

	@Override
	public List<Plan> findPlanbyCategoryId(int catid) {
		return planRepo.filterByCategoryID(catid);
	}

	@Override
	public List<Plan> filterByCatidAndDid(int catid, int newsid) {
		return planRepo.filterByCatidAndNewsid(catid, newsid);
	}

}
