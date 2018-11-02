package com.capgemini.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.employee.domain.Employee;
import com.capgemini.employee.service.EmployeeService;

@RestController
public class Controller {

	private EmployeeService employeeService;

	@Autowired
	public Controller(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<?> saveEmp(Employee employee) {

		Employee empObj = employeeService.saveEmp(employee);

		return new ResponseEntity<Employee>(empObj, HttpStatus.CREATED);

	}

}
