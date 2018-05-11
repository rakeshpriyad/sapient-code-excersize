package com.test.predqm.test;

import java.util.List;

import com.test.predqm.model.Customer;
import com.test.predqm.reader.CustomerFileReader;
import com.test.predqm.translator.CustomerInputTranslator;

public class FileReaderDemo {
	public static void main(String[] args) {
		String fileName = "C:\\Users\\aayushraj\\Desktop\\file\\" + "customer.txt";
		CustomerInputTranslator translator = new CustomerInputTranslator();
		CustomerFileReader reader = new CustomerFileReader(translator);
		List<Customer> customers = reader.read(fileName);
		display(customers);
		
	}
	
	public static void display(List<Customer> customers) {
		for(Customer customer:  customers) {
			System.out.println("Id " + customer.getId());
			System.out.println("Name " + customer.getName());
			System.out.println("Address " + customer.getAddress());
		}
	}
}
