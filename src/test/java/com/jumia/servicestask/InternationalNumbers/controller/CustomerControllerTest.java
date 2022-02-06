package com.jumia.servicestask.InternationalNumbers.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jumia.servicestask.InternationalNumbers.controller.CustomerController;
import com.jumia.servicestask.InternationalNumbers.data.CustomerRepository;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO;
import com.jumia.servicestask.InternationalNumbers.entity.Customer;
import com.jumia.servicestask.InternationalNumbers.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerRepository customerRepo;
	
	@MockBean
	private CustomerService customerService;
	
	@Test
	  public void should_find_no_customers_if_repository_is_empty() {
	    Iterable<Customer> customers = customerRepo.findAll();

	    assertThat(customers).isEmpty();
	  }
	
	@Test
	public void retrieveAllCustomers() throws Exception {
		when(customerRepo.findAllCustomers()).thenReturn(
				Arrays.asList(new CustomerDTO(1,"Walid Hammadi","(212) 6007989253","Morocco","not valid"))
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/jpa/customers/all")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\r\n" + 
						"        \"id\": 1,\r\n" + 
						"        \"name\": \"Walid Hammadi\",\r\n" + 
						"        \"phoneNumber\": \"(212) 6007989253\",\r\n" + 
						"        \"country\": \"Morocco\",\r\n" + 
						"        \"state\": \"not valid\"\r\n" + 
						"    }]"))
				.andReturn();
	}
	

}
