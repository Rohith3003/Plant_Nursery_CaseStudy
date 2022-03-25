package com.onlineplantnursery.service;

//import org.springframework.stereotype.Service;



import com.onlineplantnursery.bean.Seed;


public interface ISeedService {
	//Add new Seed
		 public Seed addSeed(Seed seed);
		
		//Update Seed information
		 public Seed updateSeedPrice(int id,double price);
		
		//Get Seed by Id
		 public Seed getSeedById(int id);
		
		//Get Seed by name
		 public Seed getSeedByName(String name);
		
		//delete Seed by Id
		 public Seed deleteSeedById(int id);
}
