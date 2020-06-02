package com.tcs.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.org.model.Role;
import com.tcs.org.repository.RoleRepository;


//import com.tcs.org.model.ProjectDetails;
//import com.tcs.org.repository.ProjectDetailsRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRole() {
		List<Role> role = new ArrayList<>();
		roleRepository.findAll()
		.forEach(role::add);
		return role;
	}
	
	public Role  getRole(int roleId) {
		return roleRepository.getOne(roleId);
	}
	
}

