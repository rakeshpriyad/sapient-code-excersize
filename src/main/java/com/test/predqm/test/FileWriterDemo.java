/*package com.test.predqm.test;

import java.util.ArrayList;
import java.util.List;

import com.test.predqm.model.Customer;
import com.test.predqm.translator.CustomerOutputTranslator;
import com.test.predqm.writer.CustomerFileWriter;

public class FileWriterDemo {
	public static void main(String[] args) {
		String fileName = "C:\\Users\\aayushraj\\Desktop\\file\\" + "customer1.txt";
		Customer c = new Customer();
		c.setId("1");
		c.setName("Rakesh");
		c.setAddress("UN");
		Customer c1 = new Customer();
		c1.setId("2");
		c1.setName("Rajesh");
		c1.setAddress("Bihar");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c);
		customers.add(c1);
		
		
		CustomerOutputTranslator  translator = new CustomerOutputTranslator();
		CustomerFileWriter writer = new CustomerFileWriter(translator);
		writer.write(customers, fileName);
	}
	
	public static void display(List<Customer> customers) {
		for(Customer customer:  customers) {
			System.out.println("Id " + customer.getId());
			System.out.println("Name " + customer.getName());
			System.out.println("Address " + customer.getAddress());
		}
	}
}
*/