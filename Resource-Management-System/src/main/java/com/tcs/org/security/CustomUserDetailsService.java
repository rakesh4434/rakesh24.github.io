/*package com.tcs.org.security;

import java.util.List;
import java.util.Optional;

//import com.example.polls.model.User;
//import com.example.polls.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.polls.security.UserPrincipal;
import com.tcs.org.exception.ResourceNotFoundException;
import com.tcs.org.model.User;
//import com.tcs.org.model.UserPrinciple;
import com.tcs.org.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        );

        return UserPrincipal.create(user);
    }
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Optional<User> user = userRepository.findByUsername(username);
                .orElseThrow(() -> 
                        new UsernameNotFoundException("User not found with username  : " + username));
      

        return UserPrincipal.create(user);
    }


    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipal.create(user);
    }
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);.orElseThrow(() -> 
                      new UsernameNotFoundException("User Not Found with -> username or email : " + username)
     // );

      return UserPrincipal.create(user);
	}
	
	public void updateUserStatus(List<User> userList) {
		
		for(User user: userList) {
			User usr =userRepository.findById(user.getUserId()).orElse(user);
			usr.setStatus(user.getStatus());
		}
		
		userRepository.saveAll(userList);
	}


}*/