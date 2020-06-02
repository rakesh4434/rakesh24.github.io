package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.tcs.org.model.Company;
import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Requirement;
import com.tcs.org.model.Skill;
import com.tcs.org.model.Status;
import com.tcs.org.service.DigitalProfileService;
import com.tcs.org.service.RequrimentService;
import com.tcs.org.service.StatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class DigitalProfileController {
	
	
	@Autowired
	private  DigitalProfileService digitalProfileService; 
	
	
	@PostMapping("/digitalProfile/add")
	public String addDigitalProfile(@RequestBody DigitalProfile digitalProfile) {
		//System.out.println(digitalProfile.getProjectDetails());
		digitalProfileService.addDigitalProfile(digitalProfile);
		return "profile added successfully..Id = "+digitalProfile.getEmpId();
	}
	
	@GetMapping("/digitalProfile")
	public List<DigitalProfile> getAllDigitalProfile() {
		return digitalProfileService.getAllDigitalProfile();
	}
	
	@GetMapping("/digitalProfile/{requirementId}")
	public List<DigitalProfile> getDigitalProfile(@PathVariable int requirementId) {
		return digitalProfileService.getDigitalProfile(requirementId);
	}
	
	@GetMapping("/digitalProfile/status/{statusId}")
	public List<DigitalProfile> getDigitalProfileByStatus(@PathVariable int statusId) {
		return digitalProfileService.getDigitalProfileByStatus(statusId);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/digitalProfile/{empId}")
	public DigitalProfile updateTopic(@RequestBody DigitalProfile digitalProfile, @PathVariable int empId) {
		 digitalProfileService.updateDigitalProfile(empId, digitalProfile);
		 return digitalProfile;
	}
	
	
	
	@GetMapping("/DigitalProfile/{empId}")
	public DigitalProfile getDigitalProfileById(@PathVariable int empId) {
		return digitalProfileService.getDigitalProfileById(empId);
 
}
	
	@GetMapping("/digitalProfile/projectDetail/{projectDetailsId}")
	public List<DigitalProfile> getDigitalProfileByProjectDetails(@PathVariable int projectDetailsId) {
		return digitalProfileService.getDigitalProfileByProjectDetails(projectDetailsId);
	}
	
	
	
	/*@GetMapping("/digitalProfile/reqs")
	public List<DigitalProfile> getAllDigitalProfileReq() {
		return digitalProfileService.getAllDigitalProfileReq();
	}
	*/
	
	
}
