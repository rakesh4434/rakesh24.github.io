/*package com.tcs.org.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.tcs.org.model.User;
import com.tcs.org.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hi i am here";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		String pwd = user.getPassword();
		String encryptPwd = passwordEncoder.encode(pwd);
		user.setPassword(encryptPwd);
		user.setTextPassword(pwd);
		userRepository.save(user);
		return "user added successfully..";
	}
	
	
}*/
