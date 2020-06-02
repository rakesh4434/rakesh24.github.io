package com.tcs.org.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.AuditDetails;
import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Location;
import com.tcs.org.model.Opportunity;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Requirement;
import com.tcs.org.model.Status;
import com.tcs.org.model.User;
import com.tcs.org.repository.DigitalProfileRepository;
import com.tcs.org.repository.LocationRepository;
import com.tcs.org.repository.OpportunityRepository;
import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class OpportunityService {
	@Autowired
	private OpportunityRepository opportunityRepository;
	
@Autowired
	
	private ProjectDetailsRepository projectDetailsRepository ;

@Autowired

private LocationRepository locationRepository ;

public Opportunity addOpportunity(@RequestBody Opportunity opportunity) {
	System.out.println(opportunity.getProjectDetails());
	ProjectDetails projectDetails	 =projectDetailsRepository.findByProjectDetailsId(opportunity.getProjectDetails().getProjectDetailsId());
	System.out.println("ProjectDetails"+projectDetails);
	opportunity.setProjectDetails(projectDetails);
//	digitalProfile.setStatus(status);
	//digitalProfileRepository.findByReqId(digitalProfile.getReqId());
	
	
	
	  Location location=locationRepository.findByLocationId(opportunity.getLocation().getLocationId());
	    //System.out.println("location"+location);
	  opportunity.setLocation(location);
	   
	 
	   
	   
	
	return opportunityRepository.save(opportunity);
	//return digitalProfileRepository.save(digitalProfile1);
}

public List<Opportunity> getAllOpportunity() {
	return opportunityRepository.findAll();
}

public void updateOpportunity(int id, Opportunity opportunity) {
	
	

	System.out.println(opportunity.getProjectDetails());
	ProjectDetails projectDetails	 =projectDetailsRepository.findByProjectDetailsId(opportunity.getProjectDetails().getProjectDetailsId());
	System.out.println("ProjectDetails"+projectDetails);
	projectDetails.setProjectDescription(opportunity.getProjectDetails().getProjectDescription());
	projectDetails.setTechnicalStackHardware(opportunity.getProjectDetails().getTechnicalStackHardware());
	projectDetails.setTechnicalStackSoftware(opportunity.getProjectDetails().getTechnicalStackSoftware());
	opportunity.setProjectDetails(projectDetails);
	
//	digitalProfile.setStatus(status);
	//digitalProfileRepository.findByReqId(digitalProfile.getReqId());
	
	
	
	  Location location=locationRepository.findByLocationId(opportunity.getLocation().getLocationId());
	    //System.out.println("location"+location);
	  opportunity.setLocation(location);
		/*Optional<Opportunity> oldUser = opportunityRepository.findById(id);
		
		if(oldUser.isPresent()) {
			List<AuditDetails> auditDets = new LinkedList<>();
			if(oldUser.get().getExpcetedcostMin()!=(opportunity.getExpcetedcostMin())) {
				AuditDetails audDet = new AuditDetails();
				audDet.setFieldName("expcetedcostMin()");
				audDet.setOldValue(Integer.toString( oldUser.get().getExpcetedcostMin()));
				audDet.setNewValue(Integer.toString(opportunity.getExpcetedcostMin()));
				auditDets.add(audDet);
			}
			*/
			
				
			opportunityRepository.save(opportunity);
		}
	 
	   
	   
	
	 
	//return digitalProfileRepository.save(digitalProfile1);



public void deleteOpportunity(int id) {
	opportunityRepository.deleteById(id);
} 
	
	

}