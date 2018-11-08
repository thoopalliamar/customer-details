package com.capgemini.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.customer.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	public Customer findByAccountID(Long empID);
	
//	public boolean testsave(Employee employee);
	
	

}
