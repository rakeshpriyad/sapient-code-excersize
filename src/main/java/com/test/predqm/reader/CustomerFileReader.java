package com.test.predqm.reader;

import com.test.predqm.model.Customer;
import com.test.predqm.translator.InputTranslator;

public class CustomerFileReader extends PreDQMFileReader<Customer> {
	private InputTranslator<Customer> translator;

	public CustomerFileReader(InputTranslator<Customer> translator, String inputFileName) {
		super(translator,inputFileName);
	}

	public InputTranslator<Customer> getTranslator() {
		return translator;
	}

	public void setTranslator(InputTranslator<Customer> translator) {
		this.translator = translator;
	}

}
