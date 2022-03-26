package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Customer;
import com.example.demo.dto.Register;
import com.example.demo.dto.RegisterOutputDto;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.PasswordDoNotMatchException;
import com.example.demo.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public RegisterOutputDto addCustomer(Register register) {
		// TODO Auto-generated method stub
		try 
		{
			Customer newCustomer = new Customer();
			newCustomer.setFullName(register.getName());
			newCustomer.setEmailId(register.getEmailId());
			newCustomer.setMobileNumber(register.getMobileNumber());
			if(!register.getPassword().equals(register.getConfirmPassword())) {
				throw new PasswordDoNotMatchException("Confirm password and Password donot match exception");
			}
			newCustomer.setAdmin(register.isAdmin());
			customerRepository.save(newCustomer);
			RegisterOutputDto registerDto = new RegisterOutputDto();
			registerDto.setEmailId(newCustomer.getEmailId());
			registerDto.setName(newCustomer.getFullName());
			return registerDto;
		} 
		catch (DataIntegrityViolationException exception) 
		{
			//Customer customer1 = customerRepository.findByEmailId(register.getEmailId());
			Customer customer2 = customerRepository.getByMobileNumber(register.getMobileNumber());
			if (customer2 != null) 
			{
				throw new DataIntegrityViolationException(
						"Customer with the given phone number already exists, try registering using other mobile number");
			}
			else
			{
				throw new DataIntegrityViolationException(
						"Customer with the given email id already exists, try registering using other email id");
				
			}
		} 
		catch (InvalidDataAccessResourceUsageException exception) 
		{
			throw new InvalidDataAccessResourceUsageException("Relation \'customer\' does not exist");
		}
		
	}

	@Override
	public List<RegisterOutputDto> getAllCustomerDto() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		List<RegisterOutputDto> registerOuput = new ArrayList<>();
		RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
		for (Customer customer : customers) {
			newRegisterOuput.setEmailId(customer.getEmailId());
			newRegisterOuput.setName(customer.getFullName());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	@Override
	public RegisterOutputDto getCustomerDtoById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer updatedCustomer = customerRepository.getById(id);
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(updatedCustomer.getEmailId());
		registerDto.setName(updatedCustomer.getFullName());
		return registerDto;
	}
	
	
	@Override
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer customer = customerRepository.getById(id);
		
		return customer;
	}

	@Override
	public List<RegisterOutputDto> getCustomersByName(String fullName) {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.getAllByFullName(fullName);
		List<RegisterOutputDto> registerOuput = new ArrayList<>();
		RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
		for (Customer customer : customers) {
			newRegisterOuput.setEmailId(customer.getEmailId());
			newRegisterOuput.setName(customer.getFullName());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}


	@Override
	public RegisterOutputDto getCustomerByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.getByMobileNumber(mobileNumber);
		if (customer == null) {
			throw new CustomerNotFoundException(
					"Customer not found with given reference mobile number : " + mobileNumber);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getEmailId());
		registerDto.setName(customer.getFullName());
		return registerDto;
	}

	@Override
	public RegisterOutputDto getCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getEmailId());
		registerDto.setName(customer.getFullName());
		return registerDto;
	}

	@Override
	public String updateEmail(String oldEmailId, String newEmailId) {
		// TODO Auto-generated method stub
		Customer updatedCustomer = customerRepository.findByEmailId(oldEmailId);
		if (updatedCustomer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + oldEmailId);
		}
		updatedCustomer.setEmailId(newEmailId);
		customerRepository.save(updatedCustomer);
		return "EmailId is successfully updated";
	}

	@Override
	public String updateName(Integer id, String fullName) {
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer updatedCustomer = customerRepository.getById(id);
		updatedCustomer.setFullName(fullName);
		customerRepository.save(updatedCustomer);
		return "Full name is successfully uploaded";
	}

	/*
	@Override
	public String updatePassword(Integer id, String oldPassword, String newPassword, String confirmNewPassword) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer updatedCustomer = customerRepository.getById(id);
		/*
		 * if(oldPassword.equals(toBeUpdateCustomer.getPassword())) { //throw new ; }
		 * else if(!newPassword.equals(confirmNewPassword)) {
		 * 
		 * } else
		 
		updatedCustomer.setPassword(newPassword);
		customerRepository.save(updatedCustomer);
		return "Password changed successfully";
	}
		*/

	@Override
	public RegisterOutputDto deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer customer = customerRepository.getById(id);
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getEmailId());
		register.setName(customer.getFullName());
		customerRepository.delete(customer);
		return register;
	}

	@Override
	public RegisterOutputDto deleteCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getEmailId());
		register.setName(customer.getFullName());
		customerRepository.delete(customer);
		return register;
	}

	
}
