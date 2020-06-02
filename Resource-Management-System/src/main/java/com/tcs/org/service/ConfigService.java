package com.tcs.org.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.org.model.Configuration;
import com.tcs.org.repository.ConfigurationRepository;

@Service
public class 	ConfigService {
	
	@Autowired
	private ConfigurationRepository configurationRepository;
	
	public Configuration addConfiguration(@RequestBody Configuration configuration) {
		  return configurationRepository.save(configuration);
	}

	public List<Configuration> getAllConfiguration() {
		return configurationRepository.findAll();
	}
	
	public void updateConfiguration(List<Configuration> configurations) {
		configurationRepository.saveAll(configurations);

	}
	
	
}