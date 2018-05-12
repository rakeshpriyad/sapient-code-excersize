package com.test.predqm.launcher;

public enum JobStatus {
	FAILED("FAILED"), COMPLETE("COMPLETE");

	JobStatus(String description) {
		this.description = description;
	}

	private String description;

	public String getDescription() {
		return description;
	}
}
