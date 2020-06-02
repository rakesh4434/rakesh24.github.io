/*package com.tcs.org.security;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.tcs.org.model.UserPrinciple;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

*//**
 * JwtProvider is an util class -> it implements useful functions:

generate a JWT token
valiate a JWT token
parse username from JWT token
 * @author 1390217
 *
 *//*

@Component
public class JwtProvider {

	 @Value("${grokonez.app.jwtSecret}")
	    private String jwtSecret;
	 
	    @Value("${grokonez.app.jwtExpiration}")
	    private int jwtExpiration;
	 
	    public String generateJwtToken(Authentication authentication) {
	 
	        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
	 
	        return Jwts.builder()
	                    .setSubject((userPrincipal.getUsername()))
	                    .setIssuedAt(new Date())
	                    .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
	                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
	                    .compact();
	    }
	 
	    public String getUserNameFromJwtToken(String token) {
	        return Jwts.parser()
	                      .setSigningKey(jwtSecret)
	                      .parseClaimsJws(token)
	                      .getBody().getSubject();
	    }
	 
	    public boolean validateJwtToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	            return true;
	        } catch (SignatureException e) {
	        	e.printStackTrace();
	           // logger.error("Invalid JWT signature -> Message: {} ", e);
	        } catch (MalformedJwtException e) {
	        	e.printStackTrace();
	           // logger.error("Invalid JWT token -> Message: {}", e);
	        } catch (ExpiredJwtException e) {
	        	e.printStackTrace();
	           // logger.error("Expired JWT token -> Message: {}", e);
	        } catch (UnsupportedJwtException e) {
	        	e.printStackTrace();
	           // logger.error("Unsupported JWT token -> Message: {}", e);
	        } catch (IllegalArgumentException e) {
	        	e.printStackTrace();
	           // logger.error("JWT claims string is empty -> Message: {}", e);
	        }
	        
	        return false;
	    }
	}*/