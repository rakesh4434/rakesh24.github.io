package com.tcs.org.repository;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.org.model.Location;
//import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
//Skill findByCompId(int compId);

}