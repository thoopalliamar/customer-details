package com.capgemini.employee.service;

import org.springframework.stereotype.Service;

import com.capgemini.employee.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee saveEmp(Employee employee) {

		return employee;
	}

}
