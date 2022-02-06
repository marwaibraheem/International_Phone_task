package com.jumia.servicestask.InternationalNumbers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.servicestask.InternationalNumbers.data.CustomerRepository;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerResponse;
import com.jumia.servicestask.InternationalNumbers.service.CustomerService;
import com.jumia.servicestask.InternationalNumbers.utils.AppConstants;
import com.jumia.servicestask.exception.CustomerNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jpa/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/all")
	public List<CustomerDTO> reterieveAllCustomer() {
		return customerRepo.findAllCustomers();

	}

	@GetMapping("/country/{country}")
	public Optional<List<CustomerDTO>> reteriveAllByCountry(@PathVariable("country") String country) {

		Optional<List<CustomerDTO>> customers = customerRepo.findByCountry(country);

		if (customers.get().isEmpty()) {

			throw new CustomerNotFoundException("country not found: " + country);
		}

		return customers;
	}

	@GetMapping("/state/{state}")
	public Optional<List<CustomerDTO>> reteriveAllByState(@PathVariable("state") String state) {

		Optional<List<CustomerDTO>> customers = customerRepo.findByState(state);

		if (customers.isPresent() && customers.get().isEmpty()) {

			throw new CustomerNotFoundException("state not found: " + state);
		}

		return customers;
	}

	@GetMapping("/phone/{phone}")
	public CustomerDTO reterieveCustomer(@PathVariable("phone") String phone) {

		Optional<CustomerDTO> customer = customerRepo.findByPhone(phone);

		if (!customer.isPresent()) {

			throw new CustomerNotFoundException("phone number not found: " + phone);
		}

		return customer.get();
	}

	@GetMapping("/find/{keyword}")
	public Optional<List<CustomerDTO>> search(@PathVariable("keyword") String keyword) {

		Optional<List<CustomerDTO>> customers = customerRepo.search(keyword);

		if (customers.isPresent() && customers.get().isEmpty()) {

			throw new CustomerNotFoundException("No data with this keyword: " + keyword);
		}

		return customers;
	}
	
	@GetMapping("/find/{keyword}/{state}")
	public Optional<List<CustomerDTO>> searchByCountryAndState(@PathVariable("keyword") String keyword,@PathVariable("state") String state) {

		Optional<List<CustomerDTO>> customers = customerRepo.searchByCountryAndState(keyword, state);

		if (customers.isPresent() && customers.get().isEmpty()) {

			throw new CustomerNotFoundException("No data with this search criteria");
		}

		return customers;
	}

	@GetMapping("/pagination")
	public CustomerResponse getAllCustomers(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize) {
		return customerService.getAllCustomersPagination(pageNo, pageSize);
	}

}
