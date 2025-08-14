package com.nt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
   @Autowired
   private JwtAuthenticationFilter jwtfilter;
   
   @Autowired
   private UserDetailsService userDetailsService;
   
   @Autowired
   private AuthenticationEntryPoint authEntryPoint;
   
    
   //password encoderbean
   @Bean
   public PasswordEncoder passwordEncoder()
   {
	   return new BCryptPasswordEncoder();
   }
   
   //authentication provider
   @Bean
   public DaoAuthenticationProvider authenticationProvider()
   {
	   DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
	   authprovider.setUserDetailsService(userDetailsService);
	   authprovider.setPasswordEncoder(passwordEncoder());
	   return authprovider;
   }
   
   //Authentication Manager
   
   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception
   {
	   return config.getAuthenticationManager();
   }
   
//   @Bean
//   public SecurityFilterChain securityfilterchain(HttpSecurity http)throws Exception
//   {
//	   http
//	       .csrf(csrf->csrf.disable())
//	          .authorizeHttpRequests(auth->auth
//	        		  .requestMatchers("/api/auth/**").permitAll()//allow login/register without token
//	          .anyRequest().authenticated()
//	          )
//	          .sessionManagement(sess->sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//	          .authenticationProvider(authenticationProvider())
//	          .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
//	   return http.build();
//   }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
           .cors(Customizer.withDefaults())
           .csrf(csrf -> csrf.disable())
           .authorizeHttpRequests(auth -> auth
               .requestMatchers("/api/auth/**","/api/users/**").permitAll() //  allow login and registration
               .anyRequest().authenticated()
           )
           .exceptionHandling(ex -> ex
               .authenticationEntryPoint(authEntryPoint) // custom entry point
           )
           .sessionManagement(sess -> sess
               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
           )
           .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);

       return http.build();
   }

}
