package com.tcs.org.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tcs.org.security.UserPrincipal;

//import AuditingConfig.java.security.UserPrincipal;
/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.tcs.org.security.UserPrincipal;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new SpringSecurityAuditAwareImpl();
    }
}

class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

    
	UserPrincipal userPrincipal;
	
	public Optional<String> getCurrentAuditor() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		    if (authentication == null || !authentication.isAuthenticated()) {
		      return null;
		    }

		  // String userName =((User) authentication.getPrincipal()).getUsername();
		  // return Optional.ofNullable(userRepository.findByUsername(userName));
		   // return Optional.ofNullable(userPrincipal.getUsername());
		    return Optional.ofNullable(userPrincipal.getUsername());
	}

}*/
/*import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import com.tcs.org.security.UserPrinciple;
import com.tcs.org.repository.UserRepository;
import com.tcs.org.security.UserPrincipal;

public class AuditingConfig implements AuditorAware<String> {

	//@Autowired
	//UserRepository userRepository;
	UserPrincipal userPrincipal;
	
	public Optional<String> getCurrentAuditor() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		    if (authentication == null || !authentication.isAuthenticated()) {
		      return null;
		    }

		  // String userName =((User) authentication.getPrincipal()).getUsername();
		  // return Optional.ofNullable(userRepository.findByUsername(userName));
		    return Optional.ofNullable(userPrincipal.getUsername());
	}

}
*/
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                if (SecurityContextHolder.getContext().getAuthentication() != null) {
                    Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
                    if(auth.getPrincipal() instanceof String) {
                    	String principal = (String)auth.getPrincipal();
                    	return Optional.ofNullable(principal);
                    }else {
                    	UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
                    	return Optional.ofNullable(userPrincipal.getUsername());
                    }
                    
                    
                    
                     
                } else {
                    return Optional.ofNullable("Unknown");
                }
            }
        };
    }
}