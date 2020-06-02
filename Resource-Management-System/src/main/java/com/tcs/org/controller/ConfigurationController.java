package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Configuration;
import com.tcs.org.model.Requirement;
import com.tcs.org.service.ConfigService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ConfigurationController {
	
	
	@Autowired
	private  ConfigService configurationService; 
	
	
	@PostMapping("/configuration/add")
	public String addConfiguration(@RequestBody Configuration configuration) {
		configurationService.addConfiguration(configuration);
		return "configuration added successfully";
	}
	
	@GetMapping("/configuration")
	public List<Configuration> getAllConfiguration() {
		return configurationService.getAllConfiguration();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/configuration")
	public List<Configuration> updateTopic(@RequestBody List<Configuration> configurations) {
		configurationService.updateConfiguration(configurations);
		 return configurations;
	}
}