package com.test.predqm.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.test.predqm.translator.OutputTranslator;
import static com.test.predqm.constant.Constants.NEWLINE;

public class PreDQMFileWriter<T> implements OutputWriter<T> {
	OutputTranslator<T> translator;

	public PreDQMFileWriter(OutputTranslator<T> translator) {
		this.translator = translator;
	}

	public boolean write(List<T> list, String fileName) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			for (T t : list) {
				String line = translator.translateToLine(t);
				fw.write(line + NEWLINE);
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Success...");
		return false;
	}

}
