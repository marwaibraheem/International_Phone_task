package com.jumia.servicestask.InternationalNumbers.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.servicestask.InternationalNumbers.data.CustomerDataRepository;
import com.jumia.servicestask.InternationalNumbers.data.CustomerRepository;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerResponse;
import com.jumia.servicestask.InternationalNumbers.entity.Customer;
import com.jumia.servicestask.InternationalNumbers.entity.CustomerData;
import com.jumia.servicestask.InternationalNumbers.service.CustomerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDataRepository customerDataRepository;

	@Autowired
	private CustomerRepository customerRepository;

	String pattern1 = "\\(237\\)\\ ?[2368]\\d{7,8}$";
	String pattern2 = "\\(251\\)\\ ?[1-59]\\d{8}$";
	String pattern3 = "\\(212\\)\\ ?[5-9]\\d{8}$";
	String pattern4 = "\\(258\\)\\ ?[28]\\d{7,8}$";
	String pattern5 = "\\(256\\)\\ ?\\d{9}$";

	@Override
	public void updateCustomerState(List<CustomerDTO> customers) {

		for (CustomerDTO customer : customers) {
			if (customer.getPhoneNumber().matches(pattern1) || customer.getPhoneNumber().matches(pattern2)
					|| customer.getPhoneNumber().matches(pattern3) || customer.getPhoneNumber().matches(pattern4)
					|| customer.getPhoneNumber().matches(pattern5)) {
				customer.setState("valid");
			} else {
				customer.setState("not valid");
			}
			customerDataRepository.save(mapToCustomerData(customer));
		}

	}

	@Override
	public CustomerResponse getAllCustomersPagination(int pageNo, int pageSize) {

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Customer> customers = customerRepository.findAll(pageable);

		// get content for page object
		List<Customer> listOfCustomers = customers.getContent();

		List<CustomerDTO> content = listOfCustomers.stream().map(customer -> mapToDTO(customer))
				.collect(Collectors.toList());

		CustomerResponse response = new CustomerResponse();
		response.setContent(content);
		response.setPageNo(customers.getNumber());
		response.setPageSize(customers.getSize());
		response.setTotalElements(customers.getTotalElements());
		response.setTotalPages(customers.getTotalPages());
		response.setLast(customers.isLast());

		return response;
	}

	private CustomerData mapToCustomerData(CustomerDTO customerDTO) {
		return new CustomerData(customerDTO.getPhoneNumber(), customerDTO.getCountry(), customerDTO.getState(),
				customerDTO.getId());
	}

	private CustomerDTO mapToDTO(Customer customer) {
		return new CustomerDTO(customer.getId(), customer.getName());
	}
	
}
