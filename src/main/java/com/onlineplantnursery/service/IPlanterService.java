package com.onlineplantnursery.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineplantnursery.bean.Planter;
import com.onlineplantnursery.repository.IPlanterRepository;

public interface IPlanterService {
	
	//Add new Planter
	public Planter addPlanter(Planter planter);
	
	//Update planter information
	public Planter updatePlanterPrice(int id,float price);
	
	//Get Planter by Id
	public Planter getPlanterById(int id);
	
	//Get Planter by name
	public Planter getPlanterByName(String name);
	
	//delete planter by Id
	public Planter deletePlanterById(int id);
}
