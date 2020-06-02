package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Opportunity;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Requirement;
import com.tcs.org.service.DigitalProfileService;
import com.tcs.org.service.OpportunityService;
import com.tcs.org.service.ProjectDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OpportunityController {

	
	@Autowired
	private  OpportunityService opportunityService; 
	@Autowired
	private  ProjectDetailsService projectDetailsService; 
	
	@PostMapping("/opportunity/add")
	public String addOpportunity(@RequestBody Opportunity opportunity) {
		//System.out.println(digitalProfile.getProjectDetails());
		opportunityService.addOpportunity(opportunity);
		return "profile added successfully..Id = "+opportunity.getId();
	}
	
	@GetMapping("/opportunity")
	public List<Opportunity> getAllOpportunity() {
		return opportunityService.getAllOpportunity();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/opportunity/{id}")
	public Opportunity updateTopic(@RequestBody Opportunity opportunity, @PathVariable int id) {
		opportunityService.updateOpportunity(id, opportunity);
		//ProjectDetails projectDetails=opportunity.getProjectDetails();
		//projectDetailsService.updateProjectDetails(projectDetails);
		 return opportunity;
	}
	
	@DeleteMapping("/opportunity/{id}")
	public void deleteOpportunity(@PathVariable int id) {
		opportunityService.deleteOpportunity(id);

	}
	
}