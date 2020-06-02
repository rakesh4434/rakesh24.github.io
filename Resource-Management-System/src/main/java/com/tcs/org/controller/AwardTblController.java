package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.AwardTbl;
import com.tcs.org.model.Skill;
import com.tcs.org.service.AwardTblService;
//import com.tcs.org.service.SkillService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AwardTblController {
	@Autowired
	private  AwardTblService  awardTblService;
	
	@GetMapping("/award")
	public List<AwardTbl> getAllAwardTbl() {
		return awardTblService.getAllAwardTbl();
	}
		
	/*@GetMapping("/skill/{compId}")
	public Skill getSkill(@PathVariable int compId) {
		return skillService.getSkill(compId);*/
}