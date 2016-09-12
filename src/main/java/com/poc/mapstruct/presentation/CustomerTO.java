package com.poc.mapstruct.presentation;

import java.util.List;

import com.poc.mapstruct.domain.Address;

public class CustomerTO {
	
	private String name;
	private List<Address> addresses;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
