package com.tcs.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.tcs.org.model.Location;
import com.tcs.org.model.ProjectDetails;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails , Integer> {
	ProjectDetails findByProjectDetailsId(int projectDetailsId);
	
}
