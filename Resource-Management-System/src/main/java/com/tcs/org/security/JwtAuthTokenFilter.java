/*package com.tcs.org.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tcs.org.service.UserService;


*//**
 * In JwtAuthTokenFilter class, the doFilterInternal method will do:

	get JWT token from header
	validate JWT
	parse username from validated JWT
	load data from users table, then build an authentication object
	set the authentication object to Security Contex
 * @author 1390217
 *
 *//*

public class JwtAuthTokenFilter extends OncePerRequestFilter {
 
    @Autowired
    private JwtProvider tokenProvider;
 
    @Autowired
    private UserService userDetailsService;
 
    
    private String getJwt(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
          
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
          return authHeader.replace("Bearer ","");
        }
 
        return null;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		   try {
		          
	            String jwt = getJwt(request);
	            if (jwt!=null && tokenProvider.validateJwtToken(jwt)) {
	                String username = tokenProvider.getUserNameFromJwtToken(jwt);
	 
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                UsernamePasswordAuthenticationToken authentication 
	                    = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	 
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            }
	        } catch (Exception e) {
	            logger.error("Can NOT set user authentication -> Message: {}", e);
	        }
	 
	        filterChain.doFilter(request, response);
		
	}
}
*/