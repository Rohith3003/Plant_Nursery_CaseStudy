package com.cs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.bean.Customer;
import com.cs.bean.GardenDecor;
import com.cs.exception.GardenDecorException;
import com.cs.repository.IGardenDecorRepository;
import com.cs.repository.ICustomerRepository;

@Service
public class GardenDecorServiceImpl implements IGardenDecorService
{
	@Autowired
	IGardenDecorRepository gdRepo;
	@Autowired
	ICustomerRepository uRepo;
	
	@Override
	public GardenDecor addGardenDecor(int id, GardenDecor gardenDecor) 
	{
		Optional<Customer> customer = uRepo.findById(id);
		if(!customer.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!customer.get().getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!customer.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else
		{
			return gdRepo.save(gardenDecor);
		}
	}
	
	@Override
	public GardenDecor getGardenDecorById(int id) 
	{
		Optional<GardenDecor> opt = gdRepo.findById(id);
		if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + id);
		}
		return opt.get();
	}

	@Override
	public List<GardenDecor> getAllGardenDecor() 
	{
		return gdRepo.findAll();
	}

	@Override
	public GardenDecor updateGardenDecorNameById(int id, int gardenDecorId, String gardenDecorName) 
	{
		Customer customer = uRepo.getById(id);
		Optional<GardenDecor> opt = gdRepo.findById(gardenDecorId);
		if(!customer.getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can update garden decor in the database");
		}
		else if(!customer.getLogin().isLogin())
		{
			throw new GardenDecorException("first login to update garden decor in the database");
		}
		else if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else
		{
			opt.get().setGardenDecorName(gardenDecorName);
			return gdRepo.save(opt.get());
		}
	}

	@Override
	public GardenDecor updateGardenDecorPriceById(int id, int gardenDecorId, double gardenDecorPrice) 
	{
		Optional<Customer> customer = uRepo.findById(id);
		Optional<GardenDecor> opt = gdRepo.findById(gardenDecorId);
		if(!customer.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!customer.get().getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!customer.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else
		{
			opt.get().setGardenDecorPrice(gardenDecorPrice);
			return gdRepo.save(opt.get());
		}
	}

	@Override
	public GardenDecor updateGardenDecorDescriptionById(int id, int gardenDecorId, String gardenDecorDescription) 
	{
		Optional<Customer> customer = uRepo.findById(id);
		Optional<GardenDecor> opt = gdRepo.findById(gardenDecorId);
		if(!customer.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!customer.get().getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!customer.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else
		{
			opt.get().setGardenDecorDescription(gardenDecorDescription);
			return gdRepo.save(opt.get());
		}
	}

	@Override
	public GardenDecor updateGardenDecorImageById(int id, int gardenDecorId, String gardenDecorImage) 
	{
		Optional<Customer> customer = uRepo.findById(id);
		Optional<GardenDecor> opt = gdRepo.findById(gardenDecorId);
		if(!customer.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!customer.get().getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!customer.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else
		{
			opt.get().setGardenDecorImage(gardenDecorImage);
			return gdRepo.save(opt.get());
		}
	}
	
	@Override
	public GardenDecor deleteGardenDecorById(int id, int gardenDecorId) 
	{
		Optional<Customer> customer = uRepo.findById(id);
		Optional<GardenDecor> opt = gdRepo.findById(gardenDecorId);
		if(!customer.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!customer.get().getRole().equals("admin"))
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!customer.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else if(!opt.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else
		{
			gdRepo.deleteById(gardenDecorId);
			return opt.get();
		}
	}
}
