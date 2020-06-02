package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Experience;
import com.tcs.org.model.Skill;
import com.tcs.org.repository.ExperienceRepository;
//import com.tcs.org.repository.SkillRepository;


//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepository;
	
	public List<Experience> getAllExperience() {
		List<Experience> experience = new ArrayList<>();
		experienceRepository.findAll()
		.forEach(experience::add);
		return experience;
	}
	
	/*public AwardTbl  getSkill(int compId) {
		return skillRepository.getOne(compId);
	}
	*/
}