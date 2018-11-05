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
public class Controller {

	private EmployeeService employeeService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public Controller(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveEmp(@RequestBody Employee employee) {
		logger.info("the employee input is been fed to service layer from controller");
		Employee empObj;
		try {
			empObj = employeeService.saveEmp(employee);
		} catch (EmployeeAlreadyExist e) {
			String exec = e.getMessage();
			return new ResponseEntity<String>(exec, HttpStatus.CONFLICT);
		}
		logger.info("the process is successful and returing the object back for review");
		return new ResponseEntity<Employee>(empObj, HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/view/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<?> viewEmp(@PathVariable Long accountId)
			throws AccountNotFoundException, IncorrectInputException {
		logger.info("Request is mapped to /view and entered saveEmp");
		try {
			Employee empObj = employeeService.viewEmp(accountId);
			logger.info("Returning the employee data from controller");
			return new ResponseEntity<Employee>(empObj, HttpStatus.FOUND);
		} catch (AccountNotFoundException | IncorrectInputException execption) {
			String exec = execption.getMessage();
			return new ResponseEntity<String>(exec, HttpStatus.CONFLICT);

		}
	}

}
