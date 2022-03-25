package com.onlineplantnursery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineplantnursery.bean.Plant;
import com.onlineplantnursery.exception.PlantNotFoundException;
import com.onlineplantnursery.repository.IPlantRepository;

@Service
public class PlantServiceImpl implements IPlantService {

	@Autowired
	IPlantRepository plantRepo;
	
	@Override
	public Plant addPlant(Plant plant) {
		// TODO Auto-generated method stub
		return plantRepo.save(plant);
	}

	@Override
	public Plant updatePlantPrice(int id, double price) {
		// TODO Auto-generated method stub
		Plant plant=new Plant();
		plant.setPrice(price);
		return plantRepo.save(plant);
	}

	@Override
	public Plant getPlantById(int id) {
		Optional<Plant> plant=plantRepo.findById(id);
		if(!plant.isPresent())
			throw new PlantNotFoundException("Plant not found with id: "+id);
		return plantRepo.getById(id);
	}

	@Override
	public Plant getPlantByName(String name) {
		// TODO Auto-generated method stub
		return plantRepo.getByName(name);
	}

	@Override
	public Plant deletePlantById(int id) {
		// Fetch the existing record from database
		Plant seed=plantRepo.getById(id);
		//Use JPARepository method
		plantRepo.delete(seed);
		return seed;
	}

}
