package com.jumia.servicestask.InternationalNumbers.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO;
import com.jumia.servicestask.InternationalNumbers.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	

	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country,cd.state) FROM Customer c join CustomerData cd on c.id=cd.customerId")
	List<CustomerDTO> findAllCustomers();
	
	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country) FROM Customer c join CustomerData cd on c.id=cd.customerId where cd.country = :country")
	Optional<List<CustomerDTO>> findByCountry(String country);
	
	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country) FROM Customer c join CustomerData cd on c.id=cd.customerId where cd.phoneNumber = :phone")
	Optional<CustomerDTO> findByPhone(String phone);
	
	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country,cd.state) FROM Customer c join CustomerData cd on c.id=cd.customerId where (cd.country LIKE %?1%)")
	Optional<List<CustomerDTO>> search(String keyword);
	
	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country,cd.state) FROM Customer c join CustomerData cd on c.id=cd.customerId where cd.state = :state")
	Optional<List<CustomerDTO>> findByState(String state);
	
	@Query(value = "SELECT new com.jumia.servicestask.InternationalNumbers.dto.CustomerDTO(c.id,c.name,cd.phoneNumber,cd.country,cd.state) FROM Customer c join CustomerData cd on c.id=cd.customerId where (cd.country LIKE %?1% And cd.state =?2)")
	Optional<List<CustomerDTO>> searchByCountryAndState(String keyword,String state);
}
