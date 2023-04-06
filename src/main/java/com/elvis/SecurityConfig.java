package com.elvis;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration 
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//define the security rules for http requests
	@Override
		protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.authorizeRequests()
		 	//put most restricted pages first, only admin can delete/edit orders
		 	.antMatchers("/orders/admin").hasRole("ADMIN")
		 	.antMatchers("/orders/showNewOrderForm").hasAnyRole("ADMIN", "MANAGER")
		 	
		 	
		 	
		 	//allow non-logged in users to see login page 
		 	.antMatchers("/login").permitAll()
		 		.and()
		 	.formLogin()	
		 	//no default login form specified. Spring boot will generate the HTML and handlers automatically.
		 	
		 	//Upon successful authentication, the user will be redirected to the /orders/all URL 
		 	//display all orders after login
		 		.defaultSuccessUrl("/orders/")
		 		.and()
		 	.httpBasic();	
	}
	
	 @SuppressWarnings("deprecation")
	 @Override
	 public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		 			.withUser("customer1").password("123").roles("USER").and()
		 			.withUser("theboss").password("123").roles("ADMIN","USER").and()
		 			.withUser("manny").password("123").roles("MANAGER","USER");
	 }
	
}
	

