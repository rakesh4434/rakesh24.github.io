package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Request;
import com.tcs.org.model.Role;
//import com.tcs.org.service.SkillService;
import com.tcs.org.service.RequestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RequestController {
	@Autowired
	private  RequestService  requestService;
	
	@GetMapping("/request")
	public List<Request> getAllRequest() {
		return requestService.getAllRequest();
	}
	@GetMapping("/request/{requestId}")
	public Request getRequestById(@PathVariable int requestId) {
		return requestService.getRequestById(requestId);
		}
}
