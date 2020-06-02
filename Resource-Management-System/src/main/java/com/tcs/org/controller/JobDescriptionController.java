package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.tcs.org.model.Applications;
import com.tcs.org.model.JobDescription;
import com.tcs.org.service.JobDescriptionService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class JobDescriptionController {
	@Autowired
	private  JobDescriptionService  jobDescriptionService;
	
	@GetMapping("/jobDescription")
	public List<JobDescription> getAllApplications() {
		return jobDescriptionService.getAllJobDescription();
	}
		
	@GetMapping("/jobDescription/{jdId}")
	public JobDescription getJobDescription(@PathVariable int jdId) {
		return jobDescriptionService.getJobDescription(jdId);
 
}

}