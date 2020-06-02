package com.tcs.org.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.Certification;
import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Location;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Requirement;
import com.tcs.org.model.Skill;
import com.tcs.org.model.Status;
//import com.tcs.org.repository.CertificationRepository;
import com.tcs.org.repository.DigitalProfileRepository;
import com.tcs.org.repository.ExperienceRepository;
import com.tcs.org.repository.LocationRepository;
import com.tcs.org.repository.ProjectDetailsRepository;
import com.tcs.org.repository.RequirementRepository;
import com.tcs.org.repository.StatusRepository;

@Service
public class 	DigitalProfileService {
	
	@Autowired
	private DigitalProfileRepository digitalProfileRepository;
	
	
	@Autowired
	
	private ProjectDetailsRepository projectDetailsRepository ;
	

@Autowired
	
	private StatusRepository statusRepository ;

@Autowired

private LocationRepository locationRepository ;
@Autowired

private RequirementRepository requirementRepository ;

	
/*@Autowired

private CertificationRepository certificationRepository ;	*/
	
/*@Autowired

private ExperienceRepository experienceRepository ;
	*/
	//private DigitalProfile digitalProfile;
	
	public DigitalProfile addDigitalProfile(@RequestBody DigitalProfile digitalProfile) {
		System.out.println(digitalProfile.getProjectDetails());
		ProjectDetails projectDetails	 =projectDetailsRepository.findByProjectDetailsId(digitalProfile.getProjectDetails().getProjectDetailsId());
		System.out.println("ProjectDetails"+projectDetails);
		digitalProfile.setProjectDetails(projectDetails);
	//	digitalProfile.setStatus(status);
		//digitalProfileRepository.findByReqId(digitalProfile.getReqId());
		
		Requirement requirement	 =requirementRepository.findById(digitalProfile.getRequirement().getId());
	//	System.out.println("Requirement"+ requirement.getId());
		 digitalProfile.setRequirement(requirement);
		
		
		  Location baseBranch=locationRepository.findByLocationId(digitalProfile.getBaseBranch().getLocationId());
		    //System.out.println("location"+location);
		    digitalProfile.setBaseBranch(baseBranch);
		   
		   Status status=statusRepository.findByStatusId(digitalProfile.getStatus().getStatusId());
		   digitalProfile.setStatus(status);
		   
		   
		
		return digitalProfileRepository.save(digitalProfile);
		//return digitalProfileRepository.save(digitalProfile1);
	}

	public List<DigitalProfile> getAllDigitalProfile() {
		return digitalProfileRepository.findAll();
		
	}
	public List<DigitalProfile> getDigitalProfile(int requirementId)
	{
		return digitalProfileRepository.findByRequirementId(requirementId);
	}
	
	public List<DigitalProfile> getDigitalProfileByStatus(int statusId)
	{
		return digitalProfileRepository.findByStatusStatusId(statusId);
	}
	
	
	
	public void updateDigitalProfile(int empId, DigitalProfile digitalProfile) {
		
		
		 Location baseBranch=locationRepository.findByLocationId(digitalProfile.getBaseBranch().getLocationId());
		    digitalProfile.setBaseBranch(baseBranch);
		    
			ProjectDetails projectDetails = projectDetailsRepository.findByProjectDetailsId(digitalProfile.getProjectDetails().getProjectDetailsId());
			digitalProfile.setProjectDetails(projectDetails);
			
			Requirement requirement	= requirementRepository.findById(digitalProfile.getRequirement().getId());
			 digitalProfile.setRequirement(requirement);
			   
			   Status status = statusRepository.findByStatusId(digitalProfile.getStatus().getStatusId());
			   digitalProfile.setStatus(status);
			   
			   
			 /*  DigitalProfile digitalProfile1=digitalProfileRepository.findByStatusId(digitalProfile.getStatus().getStatusId());
			   digitalProfile.setStatus(status);*/
			   
			   
			   digitalProfileRepository.save(digitalProfile);
	}
	
	
	
	public DigitalProfile  getDigitalProfileById(int empId) {
	    return digitalProfileRepository.findByEmpId(empId);
	}
	
	
	public List<DigitalProfile> getDigitalProfileByProjectDetails(int projectDetailsId)
	{
		return digitalProfileRepository.findByprojectDetailsId(projectDetailsId);
	}
	
	
	/*public  List<DigitalProfile>  getAllDigitalProfileReq(){
		Integer value=new Integer(digitalProfile.getReqId());
		int f=0;
		try {
			if(value !=null)
			{
				f=1;
			}
				
		}
		catch(Exception ex){
			System.out.println("NO DATA AVAILABLE");
			
		}
		finally {
			System.out.println("Good luck");
		}
		if(f==1)
			return digitalProfileRepository.findAll();
		
	*/
	
}


