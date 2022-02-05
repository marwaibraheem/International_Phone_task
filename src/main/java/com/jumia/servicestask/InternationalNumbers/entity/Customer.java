package com.jumia.servicestask.InternationalNumbers.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.ToString;

@Entity
@Table(name = "customer")
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@JsonManagedReference
	@OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CustomerData> customerData;

	public Customer() {
		super();
	}

	public Customer(Integer id, String name, List<CustomerData> customerData) {
		super();
		this.id = id;
		this.name = name;
		this.customerData = customerData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CustomerData> getCustomerData() {
		return customerData;
	}

	public void setCustomerData(List<CustomerData> customerData) {
		this.customerData = customerData;
	}
	
	

}
