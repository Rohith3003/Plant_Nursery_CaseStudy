package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Customer;
import com.example.demo.dto.Register;
import com.example.demo.dto.RegisterOutputDto;


public interface ICustomerService {
	//To add new Customer
	RegisterOutputDto addCustomer(Register register);
	//Get customer dto by id
	RegisterOutputDto getCustomerDtoById(Integer id); 
	//Get customer by id
	Customer getCustomerById(Integer id);
	//Get customer using first name
	List<RegisterOutputDto> getCustomersByName(String fullName);
    //Get customer by Email Id
  	RegisterOutputDto getCustomerByEmailId(String emailId);
  	//Get customer by Mobile Number
  	RegisterOutputDto getCustomerByMobileNumber(String mobileNumber);
	//Get all Customers
	List<RegisterOutputDto> getAllCustomerDto();
	List<Customer> getAllCustomer();
	//Update Email address
	String updateEmail(String oldEmailId,String newEmailId);
	//Update First Name
	String updateName(Integer id,String firstName);
	//Update password for account
	//String updatePassword(Integer id, String oldPassword, String newPassword, String confirmNewPassword);
	//delete a customer 
	RegisterOutputDto deleteCustomerById(Integer id);
	//delete a customer by email
	RegisterOutputDto deleteCustomerByEmailId(String emailId);
}
