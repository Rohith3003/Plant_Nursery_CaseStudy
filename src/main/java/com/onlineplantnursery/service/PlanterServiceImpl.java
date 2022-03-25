package com.onlineplantnursery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineplantnursery.bean.Planter;
import com.onlineplantnursery.exception.PlanterNotFoundException;
import com.onlineplantnursery.repository.IPlanterRepository;

@Service
public class PlanterServiceImpl implements IPlanterService {
	@Autowired
	IPlanterRepository planterRepo;

	@Override
	public Planter addPlanter(Planter planter) {
		
		return planterRepo.save(planter);
	}

//	@Override
//	public Planter updatePlanter(Planter planter) {
//		// TODO Auto-generated method stub
//		
//		return planterRepo.save(planter);
//	}

	@Override
	public Planter getPlanterById(int id) {
		Optional<Planter> planter=planterRepo.findById(id);
		if(!planter.isPresent())
			throw new PlanterNotFoundException("Planter not found with id: "+id);
		return planter.get();
	}

	@Override
	public Planter getPlanterByName(String name) {
		
		return planterRepo.getByName(name);
	}

	@Override
	public Planter deletePlanterById(int id) {
		// Fetch the existing record from database
		Planter planter=planterRepo.getById(id);
		//Use JPARepository method
		planterRepo.delete(planter);
		return planter;
	}

	@Override
	public Planter updatePlanterPrice(int id, float price) {
		
		Planter planter=planterRepo.getById(id);
		planter.setPrice(price);
		return planterRepo.save(planter);
	}
	
	
}
