package com.nt.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
	
	private final JwtUtil jwtUtil;
	
	
	private final UserDetailsService userDetailsService;
	
	@Autowired
    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
	    
	    final String authHeader = request.getHeader("Authorization");
	    String username = null;
	    String jwtToken = null;

	    // Check if header contains Bearer token
	    if (authHeader != null && authHeader.startsWith("Bearer")) {
	        jwtToken = authHeader.substring(7); // Remove 'Bearer ' prefix

	        try {
	            username = jwtUtil.extractUserName(jwtToken);
	        } catch (Exception e) {
	            System.out.println("Invalid token: " + e.getMessage());
	        }
	    }

	    // Validate token and set security context
	    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	        if (jwtUtil.validateToken(jwtToken, userDetails.getUsername())) {
	            UsernamePasswordAuthenticationToken authenticationToken =
	                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	        }
	    }

	    // Continue with the filter chain
	    filterChain.doFilter(request, response);
	}
}