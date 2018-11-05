package com.capgemini.employee.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IncorrectInputException extends Exception {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public IncorrectInputException(String s) {
		super(s);
		logger.error("##############IncorrectInputException###################");
	}

}
