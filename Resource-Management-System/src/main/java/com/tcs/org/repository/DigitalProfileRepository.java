package com.tcs.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.Location;

//import com.tcs.org.model.Requirement;

public interface DigitalProfileRepository extends JpaRepository<DigitalProfile, Integer>{
	
	List<DigitalProfile> findByRequirementId(int requirementId);
	DigitalProfile findByEmpId(int empId);
	
	List<DigitalProfile> findByStatusStatusId(int statusId);
	List<DigitalProfile> findByprojectDetailsId(int projectDetailsId);
	
	
	//DigitalProfile findByStatusId(int statusId); 

}
