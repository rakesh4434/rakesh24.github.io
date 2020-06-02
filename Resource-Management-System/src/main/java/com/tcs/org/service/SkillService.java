package com.tcs.org.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Skill;
import com.tcs.org.repository.SkillRepository;

//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class SkillService {

@Autowired
private SkillRepository skillRepository;

public List<Skill> getAllSkill() {
    List<Skill> skill = new ArrayList<>();
    skillRepository.findAll()
    .forEach(skill::add);
    return skill;
}

public Skill  getSkill(int compId) {
    return skillRepository.getOne(compId);
}
}