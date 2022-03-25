package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.bean.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
