package com.capgemini.employee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.employee.domain.Employee;
import com.capgemini.employee.exceptions.AccountNotFoundException;
import com.capgemini.employee.exceptions.EmployeeAlreadyExist;
import com.capgemini.employee.exceptions.IncorrectInputException;
import com.capgemini.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Using logger SL4j to notify status in console
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Auto wiring the EmployeeRepository to use those methods in the Service layer
	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// This method checks for existence in database and gives out error else saves
	// in database
	@Override
	public Employee saveEmp(Employee employee) throws EmployeeAlreadyExist {

		if (employeeRepository.findByAccountID(employee.getAccountID()) == null) {
			
			logger.info("the employee does not exist in the database now fed to repository layer");
			// Here we touch the repo layer to save the data from the database
			Employee retrivedEmployee = employeeRepository.save(employee);
			
			logger.info(
					"the given data is added into database and returing the data from service layer to controller layer");
			return retrivedEmployee;
		} else {
			
			logger.error(
					"the given input already exits in the database (error caught in service layer-saveEmp method)");
			throw new EmployeeAlreadyExist("The profile already exists in the database");

		}

	}

	// This methods checks for input data and gives out corresponding out catching
	// the below exceptions
	@Override
	public Employee viewEmp(Long empID) throws AccountNotFoundException, IncorrectInputException {
		logger.info("Entered viewEmp method in Service layer");
		if (empID != null&& empID == (Long)empID) {
			// Here we touch the repo layer to get the data from the database
			// retrivedEmployee is found and populated from database
			if ((employeeRepository.findByAccountID(empID) != null)) {
				Employee retrivedEmployee = employeeRepository.findByAccountID(empID);
				
				
				if(retrivedEmployee.getDeletePending()!=1) {
				logger.info("Returning the employee details from service layer");
				return retrivedEmployee;
				
				}else {
					logger.error("This accountId detail have delete_pending = 1 so not displayed");
					throw new AccountNotFoundException("Delete_pending = 1");
				}

			} else {
				logger.error("This accountId details does not exist");
				throw new AccountNotFoundException("There is no account with this ID");
			}

		} else {
			logger.error("The empId is null -- Checked in Service layer");
			throw new IncorrectInputException("Please enter valid input");

		}
	}

}
