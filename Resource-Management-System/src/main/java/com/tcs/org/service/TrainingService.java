package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Training;
import com.tcs.org.repository.TrainingRepository;


//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository trainingRepository;
	
	public List<Training> getAllTraining() {
		List<Training> training = new ArrayList<>();
		trainingRepository.findAll()
		.forEach(training::add);
		return training;
	}
	
	public Training  getTraining(int trainId) {
		return trainingRepository.getOne(trainId);
	}
	
}