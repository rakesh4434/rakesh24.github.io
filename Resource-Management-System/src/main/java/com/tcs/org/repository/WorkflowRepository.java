package com.tcs.org.repository;
//import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {

	List<Workflow> findByReqId(int reqId);
	
//Skill findByCompId(int compId);

}