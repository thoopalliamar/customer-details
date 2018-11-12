package com.capgemini.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.customer.domain.DeletedCustomer;

public interface DeletedCustomerDataRepository extends CrudRepository<DeletedCustomer, Long> {

	
	
	

}
