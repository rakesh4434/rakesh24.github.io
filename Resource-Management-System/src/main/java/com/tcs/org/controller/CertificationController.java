package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.AwardTbl;
import com.tcs.org.model.Certification;
import com.tcs.org.service.AwardTblService;
import com.tcs.org.service.CertificationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CertificationController {
	@Autowired
	private  CertificationService  certificationService;
	
	@GetMapping("/certification")
	public List<Certification> getAllCertification() {
		return  certificationService.getAllCertification();
	}
		
	/*@GetMapping("/skill/{compId}")
	public Skill getSkill(@PathVariable int compId) {
		return skillService.getSkill(compId);*/
}