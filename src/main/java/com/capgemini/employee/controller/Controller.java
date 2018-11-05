package com.capgemini.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.employee.domain.Employee;
import com.capgemini.employee.exceptions.AccountNotFoundException;
import com.capgemini.employee.exceptions.EmployeeAlreadyExist;
import com.capgemini.employee.exceptions.IncorrectInputException;
import com.capgemini.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/v1")
public class Controller {

	// Using SL4J to log the values
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Autowiring so as to access the methods in the employee service
	private EmployeeService employeeService;

	@Autowired
	public Controller(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// maps to save Checks for
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveEmp(@RequestBody Employee employee) {

		logger.info("The employee input is been fed to service layer from controller-saveEmp");

		try {

			Employee empObj = employeeService.saveEmp(employee);
			// This executes when the saving is successful
			logger.info("The process is successful and returing the object back for review");
			return new ResponseEntity<Employee>(empObj, HttpStatus.ACCEPTED);

		} catch (EmployeeAlreadyExist e) {
			// This executes when the saving of the data fails
			logger.error("The process is failed and returning the error trace-(controller-/save)");
			String error_message = e.getMessage();
			return new ResponseEntity<String>(error_message, HttpStatus.CONFLICT);
		}

	}

	// Taking input as accountID as param value and sending for processing
	@RequestMapping(value = "/view/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmp(@PathVariable Long accountId)
			throws AccountNotFoundException, IncorrectInputException {

		logger.info("The employee input is been fed to service layer from (controller-viewEmp)");
		try {

			Employee empObj = employeeService.viewEmp(accountId);

			logger.info("The process is successful and returing the object back ");
			return new ResponseEntity<Employee>(empObj, HttpStatus.FOUND);

		} catch (AccountNotFoundException | IncorrectInputException execption) {

			// This executes when the Viewing of the data fails
			logger.error("The process is failed and returning the error trace-controller-/view");

			String error_message = execption.getMessage();
			return new ResponseEntity<String>(error_message, HttpStatus.CONFLICT);

		}
	}

}
