package com.cs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.bean.Customer;
import com.cs.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	ICustomerRepository userRepo;

	@Override
	public Customer addCustomer(Customer customer) 
	{
		return userRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() 
	{
		return userRepo.findAll();
	}

}
