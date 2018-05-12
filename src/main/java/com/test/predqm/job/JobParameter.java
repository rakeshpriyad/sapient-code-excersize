package com.test.predqm.job;

import java.util.ArrayList;
import java.util.List;

public class JobParameter {
	private List<String> parameters;
	private String inputFileName;
	private String outputFileName;

	public JobParameter() {
		parameters = new ArrayList<String>();
	}

	public JobParameter(String inputFileName, String outputFileName, String... parameters) {
		this.parameters = new ArrayList<String>();
		
		for (String parameter : parameters) {
			this.parameters.add(parameter);
		}
		
		this.inputFileName = inputFileName;
		this.outputFileName = outputFileName;
	}

	public List<String> getParameters() {
		return parameters;
	}

	public void setParameters(List<String> parameters) {
		this.parameters = parameters;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public String getOutputFileName() {
		return outputFileName;
	}

	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

}
