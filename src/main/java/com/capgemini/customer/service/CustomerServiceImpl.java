package com.capgemini.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.exceptions.AccountNotFoundException;
import com.capgemini.customer.exceptions.CustomerAlreadyExist;
import com.capgemini.customer.exceptions.IncorrectInputException;
import com.capgemini.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Using logger SL4j to notify status in console
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// Auto wiring the EmployeeRepository to use those methods in the Service layer
	CustomerRepository employeeRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// This method checks for existence in database and gives out error else saves
	// in database
	@Override
	public Customer saveEmp(Customer employee) throws CustomerAlreadyExist {

		// Checking if the profile already exists in the datbase
		if (employeeRepository.findByAccountID(employee.getAccountID()) == null) {

			logger.info("The employee does not exist in the database now fed to repository layer");
			// Here we touch the repo layer to save the data from the database
			Customer savedEmployee = employeeRepository.save(employee);

			logger.info(
					"the given data is added into database and returing the data from service layer to controller layer");
			return savedEmployee;
		} else {
			// If the profile already exists the following executes
			logger.error(
					"the given input already exits in the database (error caught in service layer-saveEmp method)");
			throw new CustomerAlreadyExist("The profile already exists in the database");

		}

	}

	// This methods checks for input data and gives out corresponding out catching
	// the below exceptions
	@Override
	public Customer viewEmp(Long empID) throws AccountNotFoundException, IncorrectInputException {
		logger.info("Entered viewEmp method in Service layer");

		// Checking if the employeID is empty or not numeric
		if (empID != null && empID == (Long) empID) {
			logger.info("The input is correct ");
			// Checking if the requested account exists or not in the database
			if ((employeeRepository.findByAccountID(empID) != null)) {
				logger.info("The corresponding account exists in database");
				// Here we touch the repository layer to get the data from the database
				// retrivedEmployee is found and populated from database
				Customer retrivedEmployee = employeeRepository.findByAccountID(empID);

				// Checking got Delete_pending value for 1
				if (retrivedEmployee.getDeletePending() != 1) {
					logger.info("DeletePending()!=1");
					logger.info("Returning the employee details from service layer");
					// Returning the fetched value from database
					return retrivedEmployee;

				} else {
					// When delete_pending = 1
					logger.error("This accountId detail have delete_pending = 1 so not displayed");
					throw new AccountNotFoundException("Delete_pending = 1");
				}

			} else {
				// When accountId details does not exist
				logger.error("This accountId details does not exist");
				throw new AccountNotFoundException("There is no account with this ID");
			}

		} else {
			// When the given input value is not correct
			logger.error("The empId is null -- Checked in Service layer");
			throw new IncorrectInputException("Please enter valid input");

		}
	}

	@Override
	public void delCustomer(Long empID) throws AccountNotFoundException, IncorrectInputException {
		logger.info("Entered delEmp method in Service layer");

		// Checking if the employeID is empty or not numeric
		if (empID != null && empID == (Long) empID) {
			logger.info("The input is correct ");
			// Checking if the requested account exists or not in the database
			if ((employeeRepository.findByAccountID(empID) != null)) {
				logger.info("The corresponding account exists in database");
				// Here we touch the repository layer to get the data from the database
				// retrivedEmployee is found and populated from database
				Customer retrivedEmployee = employeeRepository.findByAccountID(empID);
				employeeRepository.delete(retrivedEmployee);
				logger.info("The account is been removed from the database");
				// Checking got Delete_pending value for 1

			} else {
				// When accountId details does not exist
				logger.error("This accountId details does not exist");
				throw new AccountNotFoundException("There is no account with this ID");
			}

		} else {
			// When the given input value is not correct
			logger.error("The empId is null -- Checked in Service layer");
			throw new IncorrectInputException("Please enter valid input");

		}

	}

}
