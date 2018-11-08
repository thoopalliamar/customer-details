package com.capgemini.customer.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerAlreadyExist extends Exception {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public CustomerAlreadyExist(String s) {
		super(s);
		logger.error("##############EmployeeAlreadyExist###################");
	}


}
