package com.capgemini.customer.service;

import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.exceptions.AccountNotFoundException;
import com.capgemini.customer.exceptions.CustomerAlreadyExist;
import com.capgemini.customer.exceptions.IncorrectInputException;

public interface CustomerService {
	
	public Customer saveEmp(Customer employee) throws CustomerAlreadyExist;

	public Customer viewEmp(Long empID) throws AccountNotFoundException,IncorrectInputException;

}
