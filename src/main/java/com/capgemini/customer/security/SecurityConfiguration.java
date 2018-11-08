package com.capgemini.customer.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	// Authentication : User --> Roles
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		
		auth
				//Defining users with roles for have control over access
				.inMemoryAuthentication()
				.withUser("user1"). password(encoder.encode("user1")).roles("USER")
				.and()
				.withUser("admin1").password(encoder.encode("admin1")).roles("USER", "ADMIN")
				.and()
				.withUser("act1").password(encoder.encode("act1")).roles("ACTUATOR");
	}
	
	
	// Authorization : Role -> Access
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http
				.httpBasic()
				.and()
				.authorizeRequests()
				//This is for view access
		        .antMatchers("/v1/view/**").hasRole("USER")
		        //This is for admin access
				.antMatchers("/v1/save").hasRole("ADMIN")
				//This is for management access
				.antMatchers("/actuator/**").hasRole("ACTUATOR")
				.and()
				.csrf().disable().headers().frameOptions().disable();
	}
}
	

