package com.jihad.example.Todolist.utils;

import java.nio.file.AccessDeniedException;
import java.sql.Date;

import org.springframework.stereotype.Component;

import com.jihad.example.Todolist.model.Utilisateur;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	   private static String secret = "This_is_secret";
	    private static long expiryDuration = 60 * 60;
	    
	    
	    public String generateJwt(Utilisateur user){
	    	
	    	   long milliTime = System.currentTimeMillis();
	           long expiryTime = milliTime + expiryDuration * 1000;

	           Date issuedAt = new Date(milliTime);
	           Date expiryAt = new Date(expiryTime);
	           
	           // claims
	           Claims claims = Jwts.claims()
	                   .setIssuer(user.getUser_id().toString())
	                   .setIssuedAt(issuedAt)
	                   .setExpiration(expiryAt);
	    
	           claims.put("username", user.getEmail());
	           claims.put("password", user.getEncryptedPassword());
	           
	      
	           return Jwts.builder()
	                   .setClaims(claims)
	                   .signWith(SignatureAlgorithm.HS512, secret)
	                   .compact();
	       }
	    public Claims verify(String authorization) throws Exception {

	        try {
	            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
	            return claims;
	        } catch(Exception e) {
	            throw new AccessDeniedException("Access Denied");
	        }

	    }
	    }
	    


