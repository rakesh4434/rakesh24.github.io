package com.tcs.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.tcs.org.model.Category;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.service.ProjectDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProjectDetailsController {
	
	@Autowired
	private ProjectDetailsService projectDetailsService;
	
	@GetMapping("/projectdetails/{id}")
	public ProjectDetails getProjectDetails(@PathVariable int id) {
		return projectDetailsService.getProjectDetails(id);
	}
}