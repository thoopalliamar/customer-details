package com.capgemini.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employee.domain.Employee;
import com.capgemini.employee.exceptions.AccountNotFoundException;
import com.capgemini.employee.exceptions.IncorrectInputException;
import com.capgemini.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee viewEmp(Long empID) throws AccountNotFoundException, IncorrectInputException {
		logger.info("Entered viewEmp method in Service layer");
		if (empID != null) {
			// Here we touch the repo layer to get the data from the database
			// retrivedEmployee is found and populated from database
			Employee retrivedEmployee = employeeRepository.findByAccountID(empID);

			if (retrivedEmployee.getAccountID() != null) {
				logger.info("Returning the employee details from service layer");
				return retrivedEmployee;
			} else {
				logger.warn("This accountId details does not exist");
				throw new AccountNotFoundException("There is no account with this ID");
			}
		} else {
			logger.warn("The empId is null -- Checked in Service layer");
			throw new IncorrectInputException("Please enter valid input");

		}
	}

}
