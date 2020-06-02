package com.tcs.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Request;
import com.tcs.org.repository.RequestRepository;
@Service
public class RequestService {
	
	@Autowired
	private RequestRepository requestRepository;
	
	public List<Request> getAllRequest() {
		
	    return requestRepository.findAll();

	}

	public Request getRequestById(int requestId) {
		// TODO Auto-generated method stub
		return requestRepository.getOne(requestId);
	}

}
