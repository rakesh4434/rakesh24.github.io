package com.tcs.org.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.DigitalProfile;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Status;
import com.tcs.org.service.ProjectDetailsService;
import com.tcs.org.service.StatusService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StatusController {
	@Autowired
	private StatusService statusService;


	
	@GetMapping("/status/{id}")
	
	public Status getStatus(@PathVariable int statusId) {
		return statusService.getStatus(statusId);
	}
}
