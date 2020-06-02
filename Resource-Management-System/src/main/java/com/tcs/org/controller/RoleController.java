package com.tcs.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.org.model.Role;
import com.tcs.org.service.RoleService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	private  RoleService  roleService;
	
	@GetMapping("/role")
	public List<Role> getAllRoles() {
		return roleService.getAllRole();
	}
		
	@GetMapping("/role/{roleId}")
	public Role getRole(@PathVariable int roleId) {
		return roleService.getRole(roleId);
 
}

}
