package com.test.predqm.translator;

import com.test.predqm.model.Customer;

public class CustomerInputTranslator implements InputTranslator<Customer> {

	public Customer translateFromLine(String line) {

		if (line == null) {
			return null;
		}

		String items[] = line.split(",");
		Customer customer = null;
		if (items != null && items.length > 0) {
			customer = new Customer();
			if (items.length >= 1) {
				customer.setId(items[0]);
			} 
			
			if (items.length >= 2) {
				customer.setName(items[1]);
			} 
			if (items.length >= 3) {
				customer.setAddress(items[2]);
			}
		}

		return customer;
	}

}
