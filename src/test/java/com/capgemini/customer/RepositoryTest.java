package com.capgemini.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RepositoryTest {
	
	private   CustomerRepository customerRepository;
	
	

	public RepositoryTest() {
		super();
	}

	@Autowired
	public void setRepositoryTest(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Test
	public void testSaveCustomer() throws Exception{
		customerRepository.save(new Customer ( 152943L, 109L,  "fresher",  "thoopalli_amarnath",  "visa", "12/22",  "private",  "direct",  "direct",  "helo", 2));
		
		Customer customer = customerRepository.findByAccountID(152943L);
		
		assertThat(customer.getBankType()).isEqualTo("direct");
	}
	

	
	

}
