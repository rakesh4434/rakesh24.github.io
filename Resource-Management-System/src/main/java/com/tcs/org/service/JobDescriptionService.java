package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.tcs.org.model.Applications;
//import com.tcs.org.model.Applications;
import com.tcs.org.model.JobDescription;
import com.tcs.org.repository.JobDescriptionRepository;

//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class JobDescriptionService {

	@Autowired
	private JobDescriptionRepository jobDescriptionRepository;
	
	public List<JobDescription> getAllJobDescription() {
		List<JobDescription> jobDescription = new ArrayList<>();
		jobDescriptionRepository.findAll()
		.forEach(jobDescription::add);
		return jobDescription;
	}
	
	public JobDescription  getJobDescription(int jdId) {
		return jobDescriptionRepository.getOne(jdId);
	}
	
}
