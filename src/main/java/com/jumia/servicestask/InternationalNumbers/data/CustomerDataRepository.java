package com.jumia.servicestask.InternationalNumbers.data;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jumia.servicestask.InternationalNumbers.entity.CustomerData;

public interface CustomerDataRepository  extends CrudRepository<CustomerData, String>{
	

	
	@Query(value="UPDATE customer_data SET state =?2 WHERE phone_number = ?1", 
		    nativeQuery = true)
	void updateCustomerData(String phoneNumber,String state);

}
