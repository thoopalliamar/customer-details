package com.capgemini.employee.service;

import com.capgemini.employee.domain.Employee;
import com.capgemini.employee.exceptions.AccountNotFoundException;
import com.capgemini.employee.exceptions.IncorrectInputException;

public interface EmployeeService {

	public Employee viewEmp(Long empID) throws AccountNotFoundException,IncorrectInputException;

}
