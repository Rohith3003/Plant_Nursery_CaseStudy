package com.cs.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Fertilizer;
import com.cs.exception.FertilizerNotFoundException;
import com.cs.repository.IFertilizerRepository;

@Service
public class FertilizerServiceImp implements IFertilizerService{
	
	@Autowired
	IFertilizerRepository fertilizerRepo;

	
	//adds new fertilizer into database
	@Override
	public Fertilizer addFertilizer(Fertilizer fertilizer) {
		return fertilizerRepo.save(fertilizer);
	}

	//deletes fertilizer from database based on id.
	@Override
	public String removeFertilizerById(int id) {
		Optional<Fertilizer> opt = fertilizerRepo.findById(id);
		if(opt.isEmpty())
		{
			throw new FertilizerNotFoundException("Fertilizer with the given id: "+id+" is not found");
		}
		fertilizerRepo.deleteById(id);
		return "fertilizer with given id: "+id+" is removed successfully"; 
	}
	
	//retrieves and returns the fertilizer from database based on given id.
	@Override
	public Fertilizer getFertilizerById(int id) {
		
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(id);
		if(fertilizer.isEmpty())
		{
			throw new FertilizerNotFoundException("Fertilizer with the given id: "+id+" is not found");
		}
		return fertilizer.get();
	}

	//retrieves and returns the fertilizer of given name.
	@Override
	public Fertilizer getFertilizerByName(String name) {
		
		Fertilizer fertilizer = fertilizerRepo.findByName(name);
		if(fertilizer==null)
		{
			throw new FertilizerNotFoundException("Fertilizer with the given name: "+name+" does not exist");
		}
		return fertilizer;
	}

	//retrieves the list of all available fertilizers
	@Override
	public List<Fertilizer> getAllFertilizers() {
		
		return fertilizerRepo.findAll();
	}

	///updates the price of existing fertilizer of given id
	@Override
	public Fertilizer updatePriceById(int id, double price) {
		
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(id);
		if(!(fertilizer.isPresent()))
		{
			throw new FertilizerNotFoundException("Fertilizer with the given id: "+id+" is not found");
		}
		fertilizer.get().setPrice(price);
		return fertilizerRepo.save(fertilizer.get());
	}

	//updates the price of existing fertilizer of given name
	@Override
	public Fertilizer updatePriceByName(String name, double price) {
		
		Fertilizer fertilizer = fertilizerRepo.findByName(name);
		if(fertilizer==null)
		{
			throw new FertilizerNotFoundException("Fertilizer with the given name: "+name+" does not exist");
		}
		fertilizer.setPrice(price);
		return fertilizerRepo.save(fertilizer);
	}

	//updates price and quantity of fertilizer of given id
	@Override
	public Fertilizer updatePriceAndQuantityById(int id, double price, String quantity) {
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(id);
		if(fertilizer.isEmpty())
		{
			throw new FertilizerNotFoundException("Fertilizer with the given id: "+id+" is not found");
		}
		fertilizer.get().setPrice(price);
		fertilizer.get().setQuantity(quantity);
		return fertilizerRepo.save(fertilizer.get());
	}

	//removes the fertilizer of given name from database
	@Override
	public Fertilizer removeFertilizerByName(String name) {
		
		Fertilizer fertilizer = fertilizerRepo.findByName(name);
		if(fertilizer==null)
		{
			throw new FertilizerNotFoundException("Fertilizer with the given name: "+name+" does not exist");
		}
		return fertilizerRepo.deleteByName(name);
	}

}
