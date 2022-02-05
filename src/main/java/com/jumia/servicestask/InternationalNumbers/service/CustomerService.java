package com.jumia.servicestask.InternationalNumbers.service;

import java.util.List;

import com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO;
import com.jumia.servicestask.InternationalNumbers.dto.CustomerResponse;

public interface CustomerService {

	void updateCustomerState(List<CustomerDTO> customers);
	
	CustomerResponse getAllCustomersPagination(int pageNo, int pageSize);
}
