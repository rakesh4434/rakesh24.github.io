/*package com.tcs.org.audit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import com.tcs.org.security.UserPrinciple;
import com.tcs.org.repository.UserRepository;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

	//@Autowired
	//UserRepository userRepository;
	
	
	public Optional<String> getCurrentAuditor() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		    if (authentication == null || !authentication.isAuthenticated()) {
		      return null;
		    }

		  // String userName =((User) authentication.getPrincipal()).getUsername();
		  //  return Optional.ofNullable(userRepository.findByUsername(userName));
		    return Optional.ofNullable(((UserPrinciple) authentication.getPrincipal()).getUsername());
	}

}
*/