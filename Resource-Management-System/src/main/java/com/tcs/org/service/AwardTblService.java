package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.AwardTbl;
import com.tcs.org.model.Skill;
import com.tcs.org.repository.AwardTblRepository;
//import com.tcs.org.repository.SkillRepository;


//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class AwardTblService {

	@Autowired
	private AwardTblRepository awardTblRepository;
	
	public List<AwardTbl> getAllAwardTbl() {
		List<AwardTbl> awardTbl = new ArrayList<>();
		awardTblRepository.findAll()
		.forEach(awardTbl::add);
		return awardTbl;
	}
	
	/*public AwardTbl  getSkill(int compId) {
		return skillRepository.getOne(compId);
	}
	*/
}