package com.capgemini.customer.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.capgemini.customer.repository.CustomerRepository;

@Component
public class HealthCheck implements HealthIndicator {

	private CustomerRepository employeeRepository;
	
	@Autowired
	public HealthCheck(CustomerRepository employeeRepository){
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public Health health() {
		int errorCode = check(); // perform some specific health check
		if (errorCode != 0) {
			return Health.down().withDetail("Application is running Database is down", errorCode).build();
		}
		return Health .status("Application is running is database is also live") .build();
	}

	public int check() {
		int i=0;
//		Boolean result = employeeRepository.testsave(new Employee(0L, 0L,"test", "test", "", "test", "test", "test", "test", "test", 0));
//		if(result == true) {
//			i =0;
//		}
		return i;
	}
}
