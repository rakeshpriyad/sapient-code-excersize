package com.test.predqm.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.test.predqm.translator.OutputTranslator;
import static com.test.predqm.constant.Constants.NEWLINE;

public class PreDQMFileWriter<T> implements OutputWriter<T> {
	private OutputTranslator<T> translator;
	private String outputFileName;
	
	public PreDQMFileWriter(OutputTranslator<T> translator, String outputFileName) {
		this.translator = translator;
		this.outputFileName = outputFileName;
	}

	public boolean write(List<T> list) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(outputFileName);
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
