package com.test.predqm.job;

import java.util.ArrayList;
import java.util.List;

import com.test.predqm.launcher.JobStatus;
import com.test.predqm.processor.ItemProcessor;
import com.test.predqm.reader.PreDQMFileReader;
import com.test.predqm.writer.PreDQMFileWriter;

public class BaseJob<I, O> implements Job<I, O> {

	protected PreDQMFileReader<I> fileReader;
	protected PreDQMFileWriter<O> fileWriter;
	protected ItemProcessor<I, O> processor;

	public BaseJob(PreDQMFileReader<I> fileReader, ItemProcessor<I, O> processor, PreDQMFileWriter<O> fileWriter) {
		this.fileReader = fileReader;
		this.processor = processor;
		this.fileWriter = fileWriter;
	}

	public JobStatus execute(JobParameter parameter) {
		preProcess(parameter);
		try {
			List<I> inputs = fileReader.read();
			List<O> outputs = new ArrayList<O>();
			for (I input : inputs) {
				try {
					O output = processor.process(input);
					outputs.add(output);
				} catch (Exception e) {
					System.out.println("Error while processing input : " + input);
				}
			}

			fileWriter.write(outputs);
		} catch (Exception e) {
			System.out.println("Error while processing customer job");
			return JobStatus.FAILED;
		}
		afterProcess(parameter);
		return JobStatus.COMPLETE;
	}

	public boolean preProcess(JobParameter parameter) {
		return true;
	}

	public boolean afterProcess(JobParameter parameter) {
		return true;
	}
}
