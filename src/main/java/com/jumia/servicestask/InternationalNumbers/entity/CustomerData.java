package com.jumia.servicestask.InternationalNumbers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "customer_data")
@Data
@Builder
@ToString
public class CustomerData {

	@Id
	@Column(name = "PHONE_NUMBER", unique = true)
	private String phoneNumber;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CUSTOMER_ID")
	@JsonBackReference
	private int customerId;
	
	

	public CustomerData() {
		super();
	}
	public CustomerData(String phoneNumber2, String country2, String state2, Integer id) {
		super();
		this.phoneNumber = phoneNumber2;
		this.country = country2;
		this.state = state2;
		this.customerId = id;
	}

}
