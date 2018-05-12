package com.test.predqm.job;

import com.test.predqm.model.Customer;
import com.test.predqm.processor.ItemProcessor;
import com.test.predqm.reader.PreDQMFileReader;
import com.test.predqm.writer.PreDQMFileWriter;

public class CustomerDataJob extends BaseJob<Customer, Customer> {
	
	public CustomerDataJob(PreDQMFileReader<Customer> fileReader, ItemProcessor<Customer, Customer> processor,
			PreDQMFileWriter<Customer> fileWriter) {
		super(fileReader, processor, fileWriter);
	}

	/*public JobStatus execute(JobParameter parameter) {
		return process(parameter);
	}

	private JobStatus process(JobParameter parameter) {
		try {
			CustomerInputTranslator inpTranslator = new CustomerInputTranslator();
			CustomerFileReader reader = new CustomerFileReader(inpTranslator);
			List<String> parameters = parameter.getParameters();
			String fileName = parameters.get(0);
			List<Customer> customers = reader.read(fileName);

			for (Customer customer : customers) {
				CustomerProcessor processor = new CustomerProcessor();
				processor.process(customer);
			}

			CustomerOutputTranslator opTranslator = new CustomerOutputTranslator();
			CustomerFileWriter writer = new CustomerFileWriter(opTranslator);
			writer.write(customers, fileName);
		} catch (Exception e) {
			System.out.println("Error while processing customer job");
			return JobStatus.FAILED;
		}
		return JobStatus.COMPLETE;
	}
*/}
