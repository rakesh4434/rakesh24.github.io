package com.tcs.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.service.OpportunityResourceService;

@RestController
@RequestMapping("/api")
public class OpportunityResourceController {
	
	@Autowired
	private  OpportunityResourceService opportunityResourceService;
	
	
	@DeleteMapping("/opportunityResource/{resourceId}")
	public void deleteOpportunityResource(@PathVariable int resourceId) {
		opportunityResourceService.deleteOpportunityResource(resourceId);
		

	}
	

}
