package com.example.demo.config;


import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



@Service
public class JwtUtil {


	    private final String SECRET = "my-secret-key-my-secret-key";

	    public String generateToken(User user) {
	    	System.out.println("++++++++++++++++++jwt"+"user.getEmail()"+user.getEmail());
	        return Jwts.builder()
	                .setSubject(user.getEmail())
	                .claim("userId", user.getId())
	                .claim("roles", user.getRole())
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
	                .signWith(SignatureAlgorithm.HS256, SECRET)
	                .compact();
	    }
	    private Key getSigningKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
	    public Claims extractClaims(String token) {

	        return Jwts.parserBuilder()
	                .setSigningKey(getSigningKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }
	}

