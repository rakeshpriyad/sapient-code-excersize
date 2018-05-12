package com.test.predqm.job;

import com.test.predqm.launcher.JobStatus;

public interface Job<I,O> {
	public JobStatus execute(JobParameter parameter);
	public boolean preProcess(JobParameter parameter);
	public boolean afterProcess(JobParameter parameter);
}
