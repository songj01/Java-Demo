package com.example.demo.config;


	
	import org.springframework.context.annotation.Bean; 
	import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
	import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
	import org.springframework.security.crypto.password.NoOpPasswordEncoder; 
	import org.springframework.security.crypto.password.PasswordEncoder; 
	@EnableWebSecurity
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	@Override
	protected void configure(AuthenticationManagerBuilder 
	authenticationManagerBuilder) throws Exception { 
	 authenticationManagerBuilder.inMemoryAuthentication() 
	 .withUser("admin") 
	 .password("admin@123") 
	 .roles("USER"); 
	 
	} 
	 
	@Bean
	public PasswordEncoder getPasswordEncoder() { 
	 return NoOpPasswordEncoder.getInstance(); 
	 } 

}
