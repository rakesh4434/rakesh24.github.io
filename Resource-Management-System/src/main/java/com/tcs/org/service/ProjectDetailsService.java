package com.tcs.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.ProjectDetails;
import com.tcs.org.repository.ProjectDetailsRepository;
@Service
public class ProjectDetailsService {
	@Autowired
	private ProjectDetailsRepository projectDetailsRepository;
	public ProjectDetails getProjectDetails(int id) {
		return projectDetailsRepository.getOne(id);
	}
	public void updateProjectDetails( ProjectDetails projectDetails) {
		System.out.println(projectDetails.getProjectName());
		projectDetailsRepository.save(projectDetails);
	}

}