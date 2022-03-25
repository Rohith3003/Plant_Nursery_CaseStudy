package com.onlineplantnursery.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineplantnursery.bean.Seed;
import com.onlineplantnursery.exception.SeedNotFoundException;
import com.onlineplantnursery.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService {
	@Autowired
	ISeedRepository seedRepo;

	@Override
	public Seed addSeed(Seed seed) {
		//Seed seedResponse=seedRepo.save(seed);
		return seedRepo.save(seed);
		// return seed;
		//System.out.println(seedResponse.)
	}

//	@Override
//	public Seed updateSeed(Seed seed) {
//		// TODO Auto-generated method stub
//		
//		return seedRepo.save(seed);
//	}

	@Override
	public Seed getSeedById(int id) {
		Optional<Seed> seed=seedRepo.findById(id);
		if(seed.isEmpty())
			throw new SeedNotFoundException("Seed not found with id: "+id);
		return seed.get();
	}

	@Override
	public Seed getSeedByName(String name) {
		
		return seedRepo.getByName(name);
	}

	@Override
	public Seed deleteSeedById(int id) {
		// Fetch the existing record from database
		Seed seed=seedRepo.getById(id);
		//Use JPARepository method
		seedRepo.delete(seed);
		return seed;
	}

	@Override
	public Seed updateSeedPrice(int id,double price) {
		
		Seed seed=seedRepo.getById(id);
		//seed.setPrice(price);
		seed.setPrice(price);
		return seedRepo.save(seed);
	}


	
}
