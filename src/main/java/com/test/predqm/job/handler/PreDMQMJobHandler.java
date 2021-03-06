package com.test.predqm.job.handler;

import com.test.predqm.job.CustomerDataJob;
import com.test.predqm.job.JobParameter;
import com.test.predqm.launcher.CustomerJobLauncher;
import com.test.predqm.launcher.JobStatus;
import com.test.predqm.model.Customer;
import com.test.predqm.processor.CustomerDataProcessor;
import com.test.predqm.processor.ItemProcessor;
import com.test.predqm.reader.CustomerFileReader;
import com.test.predqm.translator.CustomerInputTranslator;
import com.test.predqm.translator.CustomerOutputTranslator;
import com.test.predqm.utils.PropertyUtils;
import com.test.predqm.writer.CustomerFileWriter;
import static com.test.predqm.constant.Constants.INPUT_FILE_NAME;
import static com.test.predqm.constant.Constants.OUTPUT_FILE_NAME;

public class PreDMQMJobHandler {

	public static void main(String[] args) {
		handleCustomerJob();
	}

	public static void handleCustomerJob() {
		
		PropertyUtils properties = new PropertyUtils("G:\\\\RAKESH\\\\rajesh-ws\\\\PREDQM\\\\resources\\\\application.properties");
		String inputFileName = properties.getProperty(INPUT_FILE_NAME) + "customer.csv" ;//"C:\\Users\\aayushraj\\Desktop\\file\\" + "customer.txt";
		String outputFileName = properties.getProperty(OUTPUT_FILE_NAME) + "outputcustomer.csv";//"C:\\Users\\aayushraj\\Desktop\\file\\" + "customer2.txt";
		JobParameter parameter = new JobParameter();
		CustomerJobLauncher cLauncher = new CustomerJobLauncher(parameter);
		
		CustomerInputTranslator inputTranslator = new CustomerInputTranslator();
		CustomerFileReader reader = new CustomerFileReader(inputTranslator, inputFileName);
		
		ItemProcessor<Customer, Customer> processor = new CustomerDataProcessor();
		
		CustomerOutputTranslator  outputTranslator = new CustomerOutputTranslator();
		CustomerFileWriter writer = new CustomerFileWriter(outputTranslator, outputFileName);
		writer.write(reader.read());
		
		CustomerDataJob cJob = new CustomerDataJob(reader, processor, writer);
		JobStatus status = cLauncher.launch(cJob);
		System.out.println(status);
	}
}
