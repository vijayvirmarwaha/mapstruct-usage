package com.poc.mapstruct.domain;

import java.util.List;

public class Customer {

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
	private String name;
	private List<Address> addresses;
}
