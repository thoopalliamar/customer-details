package com.capgemini.employee.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountNotFoundException extends Exception {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public AccountNotFoundException(String s) {
		super(s);
		logger.error("##############AccountNotFoundException###################");
		
	}

}
