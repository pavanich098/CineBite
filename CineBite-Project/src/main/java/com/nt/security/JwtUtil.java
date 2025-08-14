package com.nt.security;

import java.util.Date; 

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;


@Component
public class JwtUtil 
{
	@Value("${jwt.secret}")
    private String SECRET_KEY;
    
    //Extract username
    public String extractUserName(String token)
    {
    	return extractClaim(token,Claims::getSubject);
    }
    
    //extract expiration date
    
    public Date extractExpiration(String token)
    {
    	return extractClaim(token,Claims::getExpiration);
    }
    
    //Generic claim extractor
    public <T> T extractClaim(String token,Function<Claims,T> claimsResolver)
    {
    	final Claims claims=extractAllClaims(token);
    	return claimsResolver.apply(claims);
    }
    
    //Generate token
    public String generateToken(String username)//String role)
    {
    	Map<String,Object> claims=new HashMap<>();
    	return createToken(claims,username);
    }

    //create token logic
	private String createToken(Map<String, Object> claims, String subject) 
	{
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*10))//10 hours
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}
	
	//validate token
	public boolean validateToken(String token,String username)
	{
		final String extractedUsername=extractUserName(token);
		return (extractedUsername.equals(username)&&!isTokenExpired(token));
	}

	//check if token is expired
	private boolean isTokenExpired(String token)
	{
		// TODO Auto-generated method stub
		return extractExpiration(token).before(new Date());
	}
	//extract all claims
	private Claims extractAllClaims(String token)
	{
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	

}
