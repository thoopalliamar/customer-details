package com.capgemini.employee.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Endpoint(id = "customEndpoint")
@Component
public class CustomEndpoint {

	@ReadOperation
	@Bean
	public String hi() {
		return "Hi from custom endpoint";
	}
}
