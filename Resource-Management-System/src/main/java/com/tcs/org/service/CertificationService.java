package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Certification;
import com.tcs.org.repository.CertificationRepository;


//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class CertificationService {

	@Autowired
	private CertificationRepository certificationRepository;
	
	public List<Certification> getAllCertification() {
		List<Certification> certification = new ArrayList<>();
		certificationRepository.findAll()
		.forEach(certification::add);
		return certification;
	}
	
	public Certification  getCertification(int certificationId) {
		return certificationRepository.getOne(certificationId);
	}
	
}
