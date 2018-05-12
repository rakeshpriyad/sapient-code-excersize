package com.test.predqm.launcher;

import com.test.predqm.job.Job;
import com.test.predqm.job.JobParameter;

public class CustomerJobLauncher implements JobLauncher {
	private JobParameter parameter;
	
	public CustomerJobLauncher(JobParameter parameter) {
		this.parameter = parameter;
	}
	
	public JobStatus launch(@SuppressWarnings("rawtypes") Job job) {
		return job.execute(parameter);
	}

}
