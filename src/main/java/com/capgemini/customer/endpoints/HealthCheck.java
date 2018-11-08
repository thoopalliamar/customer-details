package com.capgemini.customer.endpoints;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

	
	
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
