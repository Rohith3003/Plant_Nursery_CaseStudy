package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.bean.Customer;
import com.example.demo.dto.Register;
import com.example.demo.dto.RegisterOutputDto;
import com.example.demo.repository.ICustomerRepository;


@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {
	
	
	@InjectMocks
	CustomerServiceImpl customerService ;
	
	
	@MockBean
	ICustomerRepository customerRepository;
	
	RegisterOutputDto registerDto;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addCustomerTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		Customer customer = new Customer();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		RegisterOutputDto registerDto = customerService.addCustomer(register);
		assertEquals("Arun",registerDto.getName());
		assertEquals("ardoing@gmail.com",registerDto.getEmailId());
	}
	
	@Test
	void getCustomerDtoByIdTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		Customer customer = new Customer();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		RegisterOutputDto registerDto = customerService.addCustomer(register);
		RegisterOutputDto registerDto1  = customerService.getCustomerDtoById(22);
		assertEquals("Arun",registerDto.getName());
		assertEquals("ardoing@gmail.com",registerDto.getEmailId());
	}
	
	
	@Test
	void getCustomerByIdTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		Customer customer = new Customer();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Customer resultCustomer = customerService.getCustomerById(1);
		assertEquals(customer.getFullName(),resultCustomer.getFullName());
		assertEquals("Rihaan",resultCustomer.getFullName());		
		assertEquals("7978747576",resultCustomer.getMobileNumber());
		assertEquals("rihaan@gmail.com",resultCustomer.getEmailId());
	}
	
	
	
	
	@Test
	void updateEmailTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		Customer customer = new Customer();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		String resultOfUpdate = customerService.updateEmail(customer.getEmailId(),"ardoing12@gmail.com");
		assertEquals("EmailId is successfully updated",resultOfUpdate);		
	}
	
	@Test
	void deleteCustomerByIdTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		Customer customer = new Customer();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		Mockito.when(customerService.deleteCustomerById(22)).thenReturn(registerDto);
		RegisterOutputDto registerDto1 = customerService.deleteCustomerById(22);
		assertEquals("Arun",registerDto1.getName());
		assertEquals("ardoing@gmail.com",registerDto1.getEmailId());
	}
	
	
	

}
