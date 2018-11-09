package com.capgemini.customer;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customer.controller.CustomerController;
import com.capgemini.customer.domain.Customer;
import com.capgemini.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class ControllerTest {

	private MockMvc customerMockMvc;

	@MockBean
	private CustomerService customerService;

	@InjectMocks
	private CustomerController customerController;
	
	@Autowired
	 private ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		customerMockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void testViewEmp() throws Exception {

		Customer customer = new Customer(152943L, 109L, "fresher", "thoopalli_amarnath", "visa", "12/22", "private",
				"direct", "direct", "helo", 2);

		when(customerService.viewCustomer(152943L)).thenReturn(customer);
		
		customerMockMvc.perform(get("/v1/view/152943")).andExpect(status().isFound());
		verify(customerService, times(1)).viewCustomer(152943L);
		verifyNoMoreInteractions(customerService);
		
		customerMockMvc.perform(get("/v1/view")).andExpect(status().isNotFound());
		verify(customerService, times(1)).viewCustomer(152943L);
		verifyNoMoreInteractions(customerService);
		
		customerMockMvc.perform(get("/v1/view/abcgd")).andExpect(status().isBadRequest());
		verify(customerService, times(1)).viewCustomer(152943L);
		verifyNoMoreInteractions(customerService);
		
	}
	
	@Test
	public void testSaveEmp() throws Exception {

		Customer customer = new Customer(152943L, 109L, "fresher", "thoopalli_amarnath", "visa", "12/22", "private",
				"direct", "direct", "helo", 2);

		when(customerService.saveCustomer(customer)).thenReturn(customer);
		
		
		customerMockMvc.perform(post("/v1/save")
	    	       .contentType(MediaType.APPLICATION_JSON)
	    	       .content(objectMapper.writeValueAsString(customer))
	    	       .accept(MediaType.APPLICATION_JSON))
	    	       .andExpect(status().isAccepted());
		

		
	}
	
	
	public void testDeleteEmp() throws Exception{
		
		Customer customer = new Customer(152943L, 109L, "fresher", "thoopalli_amarnath", "visa", "12/22", "private",
				"direct", "direct", "helo", 2);

		when(customerService.saveCustomer(customer)).thenReturn(customer);
		
		customerMockMvc.perform(delete("/delete/{accountId}",152943L))
		.andExpect(status().isAccepted());
		verify(customerService, times(1)).delCustomer(152943L);
		verifyNoMoreInteractions(customerService);
	    	       
		
		
	}

}
