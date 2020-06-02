/*package com.tcs.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.Location;
import com.tcs.org.model.Requirement;
import com.tcs.org.model.RequirementSkill;
import com.tcs.org.model.Skill;
import com.tcs.org.repository.LocationRepository;
import com.tcs.org.repository.RequirementRepository;
import com.tcs.org.repository.RequirementSkillRepository;
import com.tcs.org.repository.SkillRepository;
@Service
public class RequirementSkillService {
	@Autowired
	private RequirementSkillRepository requirementSkillRepository;
	@Autowired
	private SkillRepository skillRepository;
	
public RequirementSkill addRequirementSkill(@RequestBody RequirementSkill requirementSkill) {

		Skill skill=skillRepository.findByCompId(requirementSkill.getSkill().getCompId());
		//System.out.println("location"+location);
		
		requirementSkill.setSkill(skill);
		return requirementSkillRepository.save(requirementSkill);
	}

	public List<RequirementSkill> getAllRequirementSkills() {
		return requirementSkillRepository.findAll();
		
	}



}
*/