package com.fdmgroup.newspage.service.test;

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

import com.fdmgroup.newspage.model.Plan;
import com.fdmgroup.newspage.repository.PlanRepository;
import com.fdmgroup.newspage.service.PlanService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PlanServiceTest {
	
	@MockBean
	PlanRepository mockRepo;
	
	@InjectMocks
	PlanService planService;
	
	@Test
	public void test_findAllPlans() {
		List<Plan> expectedList = new ArrayList<>();
		Mockito.when(mockRepo.findAll()).thenReturn(expectedList);
		planService.findAllPlans();
		verify(mockRepo).findAll();
	}

	@Test
	public void test_findPlanById() {
		Plan plan = new Plan(1, 1);
		plan.setPid(10);
		planService.findPlanById(plan.getPid());
		verify(mockRepo).findById(plan.getPid());
	}
	
	@Test
	public void test_createPlan() {
		Plan plan = new Plan(1, 1);
		Mockito.when(mockRepo.save(plan)).thenReturn(plan);
		planService.createPlan(plan);
		verify(mockRepo).save(plan);
	}
	
	@Test
	public void test_deletePlan() {
		Plan plan = new Plan(1, 1);
		plan.setPid(10);
		//Mockito.when(mockRepo.delete(plan)).thenReturn(plan);
		planService.deletePlan(plan.getPid());
		verify(mockRepo).delete(plan);
	}
	
	@Test
	public void test_findPlanbyCategoryId() {
		List<Plan> expectedList = new ArrayList<>();
		Plan plan = new Plan(1, 1);
		plan.setPid(10);
		expectedList.add(plan);
		Mockito.when(mockRepo.filterByCategoryID(expectedList.get(0).getCatid())).thenReturn(expectedList);
		planService.findPlanbyCategoryId(expectedList.get(0).getCatid());
		verify(mockRepo).filterByCategoryID(expectedList.get(0).getCatid());
	}
	
	@Test
	public void test_filterByCatidAndNewsid() {
		List<Plan> expectedList = new ArrayList<>();
		Plan plan = new Plan(1, 2);
		plan.setPid(10);
		expectedList.add(plan);
		Mockito.when(mockRepo.filterByCatidAndNewsid(expectedList.get(0).getCatid(), expectedList.get(0).getNewsid())).thenReturn(expectedList);
		planService.filterByCatidAndDid(expectedList.get(0).getCatid(), expectedList.get(0).getNewsid());
		verify(mockRepo).filterByCatidAndNewsid(expectedList.get(0).getCatid(), expectedList.get(0).getNewsid());
	}

}
