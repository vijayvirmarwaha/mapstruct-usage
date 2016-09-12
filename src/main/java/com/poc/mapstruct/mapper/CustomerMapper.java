package com.poc.mapstruct.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.poc.mapstruct.domain.Address;
import com.poc.mapstruct.domain.Customer;
import com.poc.mapstruct.jaxb.AddressDetail;
import com.poc.mapstruct.jaxb.CustomerDetail;
import com.poc.mapstruct.presentation.CustomerTO;

@Mapper
public interface CustomerMapper {
	
	CustomerMapper MAPPER=Mappers.getMapper(CustomerMapper.class);
	@Mappings({
	@Mapping(source="name", target="name"),
	@Mapping(source="addresses", target="addresses")}
			)
	CustomerTO toTarget(Customer customer);
	
	List<AddressDetail> toAddressesJaxb(List<Address> addresses);

	
	@Mappings({
		@Mapping(source="street", target="street"),
		@Mapping(source="zip", target="zip"),
		@Mapping(source="city", target="city"),
		@Mapping(source="state", target="state")


	})
	
	AddressDetail toAddressDetail(Address address);
	
	@Mappings({
		@Mapping(source="name", target="name"),
		}
				)
		CustomerDetail toJAXB(Customer customer);
	
	

}
