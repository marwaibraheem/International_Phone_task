package com.jumia.servicestask.InternationalNumbers.dto;


public class CustomerDTO {
	
	private Integer id;
	private String name;
	
	private String phoneNumber;
	private String country;
	
	private String state;
	
	public CustomerDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public CustomerDTO(Integer id, String name, String phoneNumber, String country) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.country = country;
	}
	public CustomerDTO(Integer id, String name,String phoneNumber, String country,
			 String state) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.state = state;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
