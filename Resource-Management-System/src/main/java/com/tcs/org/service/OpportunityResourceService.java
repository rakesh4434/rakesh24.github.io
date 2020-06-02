package com.tcs.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.repository.OpportunityResourceRepository;
@Service
public class OpportunityResourceService {
	
	
	@Autowired
	private OpportunityResourceRepository opportunityResourceRepository;
	
	public void deleteOpportunityResource(int resourceId) {
		opportunityResourceRepository.deleteById(resourceId);
	} 

}
