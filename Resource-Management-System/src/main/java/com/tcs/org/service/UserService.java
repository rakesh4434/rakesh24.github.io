package com.tcs.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.tcs.org.repository.ModuleProgressRepository;
//import com.tcs.org.repository.ModuleSubModuleRepository;
import com.tcs.org.repository.UserRepository;
import com.tcs.org.security.UserPrincipal;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tcs.org.model.AuditDetails;
//import com.tcs.org.model.ModuleProgress;
//import com.tcs.org.model.ModuleSubmodule;
import com.tcs.org.model.User;
//import com.tcs.org.model.UserPrinciple;


@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	/* @Autowired
    private ModuleProgressRepository moduleRep;
	 @Autowired
	 private ModuleSubModuleRepository moduleSubmoduleRepo;
	*/
	 @Autowired
	    PasswordEncoder encoder; 
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		//userRepository.findAll()
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public List<User> authenticateUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password);
	}
	
	public User getUser(String username) {
		System.out.println("*******"+username);
		return userRepository.findByUsername(username);
	}
	public Optional<User> getUserById(int userId) {
		System.out.println("*******"+userId);
		return userRepository.findByUserId(userId);
	}
	/*public List<User>  getUserByDealId(int dealId) {
		System.out.println("***dealId****"+dealId);
		return userRepository.findByDealId(dealId);
	}*/
	public void addUser(User user) {
		String pwd = user.getPassword();
		String encryptPwd = encoder.encode(pwd);
		user.setPassword(encryptPwd);
		user.setTextPassword(pwd);
		//user.setCreatedBy(Integer.toString(user.getUserId()));
		userRepository.save(user);
	}
/*	public Map<String, List<ModuleProgress>> getModuleProgress( int dealId) {
		
		List<ModuleProgress> lst=moduleRep.findByDealIdOrDealId(dealId,0);
		
		List<ModuleSubmodule> listOfSubmodule=moduleSubmoduleRepo.findAll();

	    ////select module and submodule list and check the occurence of module and submodule in list and add it in list.
		
		
			
		Map<String, List<ModuleSubmodule>> moduleDetMap1 = listOfSubmodule.stream().collect(
                Collectors.groupingBy(ModuleSubmodule::getModuleName));
		
		boolean flag=true;
		//for(int i=0, j=0;i<listOfSubmodule.size()&&j<lst.size();j++,i++) {
		for(int i=0;i<listOfSubmodule.size();i++) {
			ModuleSubmodule obj =listOfSubmodule.get(i);
			flag=true;
			for(int j=0;j<lst.size();j++) {
				ModuleProgress obj2= lst.get(j);
				if(obj2.getModule().equals(obj.getModuleName()) && obj2.getName().equals(obj.getSubmoduleName())) {
					flag=false;
				}
			}
			if(flag) {
				ModuleProgress o=new ModuleProgress();
				o.setModule(obj.getModuleName());
				o.setName(obj.getSubmoduleName());
				lst.add(o);
			}
		}
		
		
	
		Map<String, List<ModuleProgress>> moduleDetMap = lst.stream().collect(
                Collectors.groupingBy(ModuleProgress::getModule));
		
		return moduleDetMap;
	}

*/
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);/*.orElseThrow(() -> 
                      new UsernameNotFoundException("User Not Found with -> username or email : " + username)*/
     // );

      return UserPrincipal.create(user);
	}
	
	public void updateUserStatus(List<User> userList) {
		
		/*for(User user: userList) {
			User usr =userRepository.findById(user.getUserId()).orElse(user);
			usr.setStatus(user.getStatus());
		}*/
		
		userRepository.saveAll(userList);
	}

	public void updateUser(int userId, User updatedUser) {
		// TODO Auto-generated method stub
/*		Optional<User> oldUser = userRepository.findByUserId(userId);
		
		if(oldUser.isPresent()) {
			List<AuditDetails> auditDets = new LinkedList<>();
			if(!oldUser.get().getEmail().equals(updatedUser.getEmail())) {
				AuditDetails audDet = new AuditDetails();
				audDet.setFieldName("email");
				audDet.setOldValue(oldUser.get().getEmail());
				audDet.setNewValue(updatedUser.getEmail());
				auditDets.add(audDet);
			}
			updatedUser.setAuditDetails(auditDets);*/
			
				
				userRepository.save(updatedUser);
		}
		
	}


