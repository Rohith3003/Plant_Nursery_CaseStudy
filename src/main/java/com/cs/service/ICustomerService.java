package com.cs.service;

import java.util.List;
import com.cs.bean.Customer;


public interface ICustomerService 
{
	Customer addCustomer(Customer customer);
	List<Customer> getAllCustomer();
}
