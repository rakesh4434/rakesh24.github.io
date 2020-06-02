package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.AwardTbl;
import com.tcs.org.model.Training;
import com.tcs.org.service.AwardTblService;
import com.tcs.org.service.TrainingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TrainingController {
	@Autowired
	private  TrainingService  trainingService;
	
	@GetMapping("/training")
	public List<Training> getAllTraining() {
		return  trainingService.getAllTraining();
	}
		
	/*@GetMapping("/skill/{compId}")
	public Skill getSkill(@PathVariable int compId) {
		return skillService.getSkill(compId);*/
}