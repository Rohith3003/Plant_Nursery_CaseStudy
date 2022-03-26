package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	//List<Customer> findByFirstName(String firstName);
	
	Customer findByEmailId(String emailId);
	
	@Query(value ="select * from customer c where c.full_name = :fullName",nativeQuery=true)
	List<Customer> getAllByFullName(@Param("fullName")String fullName);
	
	@Query(value ="select * from customer c where c.mobile_number = :mobileNumber",nativeQuery=true)
	Customer getByMobileNumber(@Param("mobileNumber") String mobileNumber);	
	
}
