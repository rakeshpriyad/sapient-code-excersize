package com.test.predqm.reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.test.predqm.translator.InputTranslator;

public class PreDQMFileReader<T> implements FileReader<T> {

	private InputTranslator<T> translator;
	
	public PreDQMFileReader(InputTranslator<T> translator){
		this.translator = translator;
	}

	public List<T> read(String fileName) {
		if(fileName == null) {
			throw new NullPointerException("File name can not be null");
		}
		
		Scanner sc = null;
		List<T> items = new ArrayList<T>();
		try {
			sc = new Scanner(new File(fileName));
			while (sc.hasNext()) {
				String line = sc.nextLine();
				System.out.println("Read line : " + line);
				T t = translator.translateFromLine(line);
				items.add(t);
			}
		} catch (IOException e) {
			System.out.println("Error occured during reading file: " + fileName);
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return items;
	}

}
