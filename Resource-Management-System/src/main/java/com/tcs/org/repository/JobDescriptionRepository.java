package com.tcs.org.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.JobDescription;
//import com.tcs.org.model.ProjectDetails;

@Repository
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Integer> {
	

}