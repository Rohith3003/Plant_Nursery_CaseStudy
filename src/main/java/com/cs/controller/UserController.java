package com.cs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cs.bean.Customer;
import com.cs.service.ICustomerService;


@RestController
public class UserController 
{
	@Autowired
	ICustomerService cServ;

	@PostMapping("/addCustomer")
	ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) 
	{
		Customer c = cServ.addCustomer(customer);
		return new ResponseEntity<>(c, HttpStatus.OK);
	};
	
	@GetMapping("/getAllCustomer")
	ResponseEntity<List<Customer>> getAllCustomer() 
	{
		List<Customer> c = cServ.getAllCustomer();
		return new ResponseEntity<>(c, HttpStatus.OK);
	};
}
