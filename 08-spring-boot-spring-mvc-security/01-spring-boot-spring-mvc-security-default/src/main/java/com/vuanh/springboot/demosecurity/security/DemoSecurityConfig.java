package com.vuanh.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		
		UserDetails VuAnh = User.builder()
				.username("VuAnh")
				.password("{noop}dinhvuanh123")
				.roles("Employee")
				.build();
		
		
		UserDetails Nhi = User.builder()
				.username("Nhi")
				.password("{noop}tranlinhnhi123")
				.roles("Employee, Manager")
				.build();
		
		UserDetails Admin = User.builder()
				.username("Admin")
				.password("{noop}admin123")
				.roles("Employee, Manager, Admin")
				.build();
		
		
		return new InMemoryUserDetailsManager(VuAnh, Nhi, Admin);
	}
	
	
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer ->
					configurer
							.anyRequest().authenticated()
			)
			.formLogin(form ->
					form
							.loginPage("/showMyLoginPage")
							.loginProcessingUrl("/authenticateTheUser")
							.permitAll()
			);
			
		
		return http.build();
	}
}
