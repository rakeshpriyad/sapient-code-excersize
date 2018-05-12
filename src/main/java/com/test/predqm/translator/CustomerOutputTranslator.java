package com.test.predqm.translator;

import static com.test.predqm.constant.Constants.COMMA;

import com.test.predqm.model.Customer;

public class CustomerOutputTranslator implements OutputTranslator<Customer> {

	public String translateToLine(Customer customer) {

		if (customer == null) {
			return null;
		}

		String line = customer.getId() + COMMA + customer.getName() + COMMA + customer.getAddress();
		return line;
	}

}
