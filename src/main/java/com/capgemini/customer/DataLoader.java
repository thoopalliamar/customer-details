package com.capgemini.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.service.CustomerService;

@Component
public class DataLoader implements ApplicationRunner {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private CustomerService employeeservice;
	
	public DataLoader(CustomerService employeeservice) {
		this.employeeservice=employeeservice;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("the data is fed to sql database with the help of application runner");
		employeeservice.saveEmp(new Customer(100L, 152943L,"fresher", "thoopalli_amarnath", "", "visa", "12/22", "private", "direct", "direct", 2));
		employeeservice.saveEmp(new Customer(101L, 152944L,"fresher", "sai saketh", "", "master_card", "10/24", "public", "direct", "direct", 1));
		employeeservice.saveEmp(new Customer(102L, 152945L,"", "vishnu vardhan", "", "", "1/26", "private", "direct", "direct", 2));
		employeeservice.saveEmp(new Customer(103L, 152946L,"fresher", "leela", "", "rupay", "2/21", "public", "direct", "direct", 2));
		employeeservice.saveEmp(new Customer(104L, 152947L,"senior", "sai teja", "", "visa", "5/22", "private", "direct", "direct", 2));
		employeeservice.saveEmp(new Customer(105L, 152948L,"fresher", "saisree", "", "master_card", "8/29", "public", "direct", "direct", 1));
        logger.info("the data is been updated in the database from application runner");	
	}

}
