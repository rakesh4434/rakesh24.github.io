package com.tcs.org.repository;
//import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Request;
import com.tcs.org.model.Requirement;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

//	List<Requirement> findRequirementByRequestId(int requestId);
//Skill findByCompId(int compId);

}