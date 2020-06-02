package com.tcs.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.org.model.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Integer>{
	
	Requirement findById(int Id);

	List<Requirement> findByOpportunityId(int opportunityId);
	List<Requirement> findByStatus(int status);

	/*List<Requirement> findbyStatusAndProjectId(int status, int[] projid);

	List<Requirement> findbyStatusAndProjectDetailsId(int status, int[] projid);*/

	List<Requirement> findByStatusInAndProjectDetailsId(int status, int projectDetailsId);
	//List<Requirement> findByRequestId(int requestId);

}
