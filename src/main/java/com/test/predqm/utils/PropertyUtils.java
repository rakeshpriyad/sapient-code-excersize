package com.test.predqm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
	Properties prop;

	public PropertyUtils(String propertyFileName) {
		prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream(propertyFileName);
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public String getProperty(String propName) {
		return (String) prop.get(propName);
	}

	public static void main(String[] args) {
		PropertyUtils properties = new PropertyUtils(
				"G:\\RAKESH\\rajesh-ws\\PREDQM\\resources\\application.properties");
		System.out.println(properties.getProperty("input.file.path"));
		System.out.println(properties.getProperty("output.file.path"));
	}
}
