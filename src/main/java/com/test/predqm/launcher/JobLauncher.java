package com.test.predqm.launcher;

import com.test.predqm.job.Job;

public interface JobLauncher {
	@SuppressWarnings("rawtypes")
	public JobStatus launch(Job job);
}
