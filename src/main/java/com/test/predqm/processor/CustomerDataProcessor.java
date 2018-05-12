package com.test.predqm.processor;

import com.test.predqm.model.Customer;

public class CustomerDataProcessor implements ItemProcessor<Customer, Customer> {

	public Customer process(Customer input) {
		System.out.println(" Input is : " + input);
		Customer nCustomer = new Customer();
		nCustomer.setId(input.getId() + "1");
		nCustomer.setName(input.getName());
		nCustomer.setAddress(input.getAddress());
		return nCustomer;
	}

}
