package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Experience;
import com.tcs.org.service.ExperienceService;
//import com.tcs.org.service.SkillService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ExperienceController {
	@Autowired
	private  ExperienceService  experienceService;
	
	@GetMapping("/experience")
	public List<Experience> getAllExperience() {
		return experienceService.getAllExperience();
	}
		
	/*@GetMapping("/skill/{compId}")
	public Skill getSkill(@PathVariable int compId) {
		return skillService.getSkill(compId);*/
}