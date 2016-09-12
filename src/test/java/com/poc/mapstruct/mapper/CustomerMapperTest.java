/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.poc.mapstruct.mapper;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.junit.Test;

import com.poc.mapstruct.domain.Address;
import com.poc.mapstruct.domain.Customer;
import com.poc.mapstruct.jaxb.CustomerDetail;
import com.poc.mapstruct.jaxb.ObjectFactory;
import com.poc.mapstruct.presentation.CustomerTO;


/**
 *
 * @author Vijay Marwaha
 */
public class CustomerMapperTest {

    public CustomerMapperTest() {
    }

    /**
     * My first test to understand how it works
     */
    @Test
    public void testCustomerMappingForName() {

       
    	Customer customer= new Customer();
    	customer.setName("Vj");
    	
    	CustomerTO customerTO= CustomerMapper.MAPPER.toTarget(customer);
    	
    	System.out.println("customerTarget is:"+customerTO.getName());
    	assertEquals(customerTO.getName(),customer.getName());
    }

    /**
     * Test setting up the list one to one mapping
     */
    @Test
    public void testCustomerAddressMappingList() {

       
    	Customer customer= new Customer();
    	customer.setName("Vj");
    	List<Address> addresses = new ArrayList<Address>();
    	
    	addresses.add(new Address("Dev St", 94105, "SF", "CA"));
    	addresses.add(new Address("Test St", 94110, "SF", "CA"));
    	customer.setAddresses(addresses);
    	
    	CustomerTO customerTO= CustomerMapper.MAPPER.toTarget(customer);
    	
    	System.out.println("customer addresses is:"+customerTO.getAddresses().toString());
    	assertEquals(customerTO.getName(),customer.getName());
    	assertEquals(customerTO.getAddresses().size(),customer.getAddresses().size());
    }
 
    @Test
    public void testCustomerAddressMappingDomainToJAXB()throws Exception{
    	
    	Customer customer= new Customer();
    	customer.setName("Vj");
    	List<Address> addresses = new ArrayList<Address>();
    	
    	addresses.add(new Address("Dev St", 94105, "SF", "CA"));
    	addresses.add(new Address("Test St", 94110, "SF", "CA"));
    	customer.setAddresses(addresses);
    	CustomerDetail customerDetail= CustomerMapper.MAPPER.toJAXB(customer);
    	
    	JAXBContext context= JAXBContext.newInstance(CustomerDetail.class);
    	Marshaller marshaller= context.createMarshaller();
    	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	marshaller.marshal(new JAXBElement<CustomerDetail>(new QName("uri","local"), CustomerDetail.class, customerDetail), System.out);

    	assertEquals(customerDetail.getName(),customer.getName());

    	
//    	
//    	assertEquals(customerDetail.getAddresses(),customer.getAddresses());
//

    	
    	
    }
    
      
}
