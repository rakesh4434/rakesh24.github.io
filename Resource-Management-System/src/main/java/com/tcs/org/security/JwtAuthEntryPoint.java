/*package com.tcs.org.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
*//**
 * handle Error exception when having unauthorized requests.
 * @author 1390217
 *
 *//*

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
 
    
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) 
                             throws IOException, ServletException {
      
       System.out.println("Unauthorized error. Message - {}"+e.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
    }
}*/