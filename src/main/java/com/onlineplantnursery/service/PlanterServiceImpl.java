package com.onlineplantnursery.service;

import java.util.List;
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
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add planter to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add planter to the database");
//		}
//		else
//		{
		return planterRepo.save(planter);
//		}
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
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add planter to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add planter to the database");
//		}
//		else
//		{
		return planterRepo.getByName(name);
//		}
	}

	@Override
	public Planter deletePlanterById(int id) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add planter to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add planter to the database");
//		}
//		else
//		{
		// Fetch the existing record from database
		Optional<Planter> planter=planterRepo.findById(id);
		if(!planter.isPresent())
			throw new PlanterNotFoundException("Planter not found with id: "+id);
		//Use JPARepository method
		planterRepo.delete(planter.get());
		return planter.get();
//		}
	}

	@Override
	public Planter updatePlanterPrice(int id, float price) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add planter to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add planter to the database");
//		}
//		else
//		{
			Optional<Planter> planter=planterRepo.findById(id);
			if(!planter.isPresent())
				throw new PlanterNotFoundException("Planter not found with id: "+id);
			Planter updatedPlanter=planter.get();
			updatedPlanter.setPrice(price);
			return planterRepo.save(updatedPlanter);
//		}
	}

	@Override
	public List<Planter> getAllPlanters() {
		// Fetches all the planter records from DB
		return planterRepo.findAll();
	}

	@Override
	public Planter updatePlanterPhoto(int planterId,String photoLoc) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add planter to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add planter to the database");
//		}
//		else
//		{
			Optional<Planter> planter=planterRepo.findById(planterId);
			if(!planter.isPresent())
				throw new PlanterNotFoundException("Planter not found with id: "+planterId);
			Planter updatedPlanter=planter.get();
			updatedPlanter.setPhotoLoc(photoLoc);
			return planterRepo.save(updatedPlanter);
//		}
	}
	
	
}
