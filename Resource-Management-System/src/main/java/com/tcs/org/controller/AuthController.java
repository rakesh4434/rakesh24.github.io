package com.tcs.org.controller;
import com.tcs.org.exception.AppException;
import com.tcs.org.model.JwtResponse;
import com.tcs.org.model.ProjectDetails;
import com.tcs.org.model.Role;
import com.tcs.org.model.RoleName;
//import com.tcs.org.model.RoleName;
import com.tcs.org.model.User;
import com.tcs.org.payload.ApiResponse;
import com.tcs.org.payload.JwtAuthenticationResponse;
import com.tcs.org.payload.LoginRequest;
import com.tcs.org.payload.SignUpRequest;
import com.tcs.org.repository.RoleRepository;
import com.tcs.org.repository.UserRepository;
import com.tcs.org.security.JwtTokenProvider;
import com.tcs.org.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

@Autowired
AuthenticationManager authenticationManager;

@Autowired
UserRepository userRepository;

@Autowired
RoleRepository roleRepository;

@Autowired
PasswordEncoder passwordEncoder;

@Autowired
JwtTokenProvider tokenProvider;
@Autowired
private UserService userService;
/* @PostMapping(/signin)
public ResponseEntity<?> authenticateUser(@Valid @RequestBody User loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
}*/
 @PostMapping("/users/authenticate")
 public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
     Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt,userService.getUser(user.getUsername())));
 }

@PostMapping("/signup")
public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) throws NumberFormatException {
    if(userRepository.existsByUsername(signUpRequest.getUsername())) {
        return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                HttpStatus.BAD_REQUEST);
    }

    if(userRepository.existsByEmail(signUpRequest.getEmail())) {
        return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                HttpStatus.BAD_REQUEST);
    }
    
    if(userRepository.existsById(signUpRequest.getUserId())) {
        return new ResponseEntity(new ApiResponse(false, "UserId already in use!"),
                HttpStatus.BAD_REQUEST);
    }

    // Creating user's account
    User user = new User(signUpRequest.getUserId(), signUpRequest.getEmail(),
            signUpRequest.getPassword(), signUpRequest.getStatus(),signUpRequest.getTextPassword(),signUpRequest.getUsername(),signUpRequest.getAccountName(),signUpRequest.getIou());

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    Set<Role> roles = new HashSet<>();
    for(Role role: signUpRequest.getRoles()) {
        Role userRole = roleRepository.findById(role.getRoleId())
                .orElseThrow(() -> new AppException("User Role not set."));
        roles.add(userRole);
    }
   
    List<ProjectDetails> projectDetails=new ArrayList<>();
    List<ProjectDetails> pDetails=signUpRequest.getProjectDetails();
    user.setProjectDetails(pDetails);


    user.setRoles( roles);

    User result = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/api/users/{username}")
            .buildAndExpand(result.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
}
}






/*package com.tcs.org.controller;

import  com.tcs.org.exception.AppException;
import com.tcs.org.model.Role;
import com.tcs.org.model.RoleName;
//import com.tcs.org.model.RoleName;
import com.tcs.org.model.User;
import com.tcs.org.payload.ApiResponse;
import com.tcs.org.payload.JwtAuthenticationResponse;
import com.tcs.org.payload.LoginRequest;
import com.tcs.org.payload.SignUpRequest;
import com.tcs.org.repository.RoleRepository;
import com.tcs.org.repository.UserRepository;
import com.tcs.org.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
import java.util.TreeSet;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws NumberFormatException {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUserId(), signUpRequest.getEmail(),
                signUpRequest.getPassword(), signUpRequest.getStatus(),signUpRequest.getTextPassword(),signUpRequest.getUsername());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        for(RoleName roleName: signUpRequest.getRoleNames()) {
        	Role userRole = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new AppException("User Role not set."));
        	roles.add(userRole);
        }
        

        user.setRoles( roles);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}*//*package com.tcs.org.controller;

import  com.tcs.org.exception.AppException;
import com.tcs.org.model.JwtResponse;
import com.tcs.org.model.Role;
import com.tcs.org.model.RoleName;
//import com.tcs.org.model.RoleName;
import com.tcs.org.model.User;
import com.tcs.org.payload.ApiResponse;
import com.tcs.org.payload.JwtAuthenticationResponse;
import com.tcs.org.payload.LoginRequest;
import com.tcs.org.payload.SignUpRequest;
import com.tcs.org.repository.RoleRepository;
import com.tcs.org.repository.UserRepository;
import com.tcs.org.security.JwtTokenProvider;
import com.tcs.org.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
	private UserService userService;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody User loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
	 @PostMapping("/users/authenticate")
	 public ResponseEntity<?> authenticateUser(@Valid @RequestBody User user) {
		 Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		user.getUsername(),
	                		user.getPassword()
	                )
	        );
	 
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	 
	        String jwt = tokenProvider.generateToken(authentication);
	        return ResponseEntity.ok(new JwtResponse(jwt,userService.getUser(user.getUsername())));
	 }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User signUpRequest) throws NumberFormatException {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsById(signUpRequest.getUserId())) {
        	 return new ResponseEntity(new ApiResponse(false, "userId already in use!"),
                     HttpStatus.BAD_REQUEST);
        	
        }

        // Creating user's account
        User user = new User(signUpRequest.getUserId(), signUpRequest.getEmail(),
                signUpRequest.getPassword(), signUpRequest.getStatus(),signUpRequest.getTextPassword(),signUpRequest.getUsername());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        for(Role role: signUpRequest.getRoles()) {
        	Role userRole = roleRepository.findById(role.getRoleId())
                    .orElseThrow(() -> new AppException("User Role not set."));
        	roles.add(userRole);
        }
        

        user.setRoles( roles);

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
}*/

