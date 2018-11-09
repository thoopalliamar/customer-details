package com.capgemini.customer.service;

import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.exceptions.AccountNotFoundException;
import com.capgemini.customer.exceptions.CustomerAlreadyExist;
import com.capgemini.customer.exceptions.IncorrectInputException;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer) throws CustomerAlreadyExist;

	public Customer viewCustomer(Long empID) throws AccountNotFoundException,IncorrectInputException;

	public void delCustomer(Long empID) throws AccountNotFoundException,IncorrectInputException;
}
