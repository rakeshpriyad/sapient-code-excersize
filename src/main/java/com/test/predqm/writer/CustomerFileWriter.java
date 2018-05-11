package com.test.predqm.writer;

import com.test.predqm.model.Customer;
import com.test.predqm.translator.OutputTranslator;

public class CustomerFileWriter extends PreDQMFileWriter<Customer> {
	OutputTranslator<Customer> translator;

	public CustomerFileWriter(OutputTranslator<Customer> translator) {
		super(translator);
	}
}
