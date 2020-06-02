package com.tcs.org.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Location;
import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Requirement;
import com.tcs.org.model.Skill;
import com.tcs.org.repository.LocationRepository;
import com.tcs.org.repository.ProjectDetailsRepository;
import com.tcs.org.repository.RequirementRepository;
import com.tcs.org.repository.SkillRepository;

@Service
public class RequrimentService {

@Autowired
private RequirementRepository requirementRepository;
@Autowired
private LocationRepository locationRepository;
@Autowired
private ProjectDetailsRepository projectDetailsRepository;
/*@Autowired
private SkillRepository skillRepository;*/


public Requirement addRequirement(@RequestBody Requirement requirement) {
    Location location=locationRepository.findByLocationId(requirement.getLocation().getLocationId());
    System.out.println("location"+location);
    requirement.setLocation(location);

    ProjectDetails projectDetails=projectDetailsRepository.findByProjectDetailsId(requirement.getProjectDetails().getProjectDetailsId());
    requirement.setProjectDetails(projectDetails);

/*  Skill skill=skillRepository.findByCompId(requirement.getSkill().getCompId());
    requirement.setSkill(skill);*/

    return requirementRepository.save(requirement);
}

public List<Requirement> getAllRequirements() {
    return requirementRepository.findAll();

}

/*public Optional<Requirement> getProjectDetails(int id) {
    return requirementRepository.findById(id);
}*/

public void addRequirement1(Requirement requirement) {
	requirementRepository.save(requirement);

}
public List<Requirement> findAll() {
	
	return requirementRepository.findAll();
}



public void updateRequirement(int id, Requirement requirement) {

    Location location=locationRepository.findByLocationId(requirement.getLocation().getLocationId());
    //System.out.println("location"+location);
    requirement.setLocation(location);
    ProjectDetails projectDetails=projectDetailsRepository.findByProjectDetailsId(requirement.getProjectDetails().getProjectDetailsId());
    requirement.setProjectDetails(projectDetails);
    /*Skill skill=skillRepository.findByCompId(requirement.getSkill().getCompId());
    requirement.setSkill(skill);*/
    requirementRepository.save(requirement);

}

public void deleteRequirement(int id) {
    requirementRepository.deleteById(id);
} 


public List<Requirement> getRequirementByOpportunity(int opportunityId)
{
	return requirementRepository.findByOpportunityId(opportunityId);
}
public List<Requirement> getRequirementByStatus(int status)
{
	return requirementRepository.findByStatus(status);
}
public List<Requirement> getRequirementByStatusandProjectId(int status, int projectDetailsId) {
	return requirementRepository.findByStatusInAndProjectDetailsId(status , projectDetailsId);
}
}