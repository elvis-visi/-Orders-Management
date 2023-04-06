package com.elvis;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
		 	
		 	//settings for the REST API used by the S.P.A.
			.antMatchers(HttpMethod.POST,"/api/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers(HttpMethod.PUT,"/api/**").hasAnyRole("ADMIN", "MANAGER")
			.antMatchers(HttpMethod.DELETE,"/api/**").hasAnyRole("ADMIN")
		 	
			//only authenticated users can access the api
			.antMatchers("/api/**").authenticated()
			.antMatchers("/orders/**").authenticated()
		 	
		 	//allow non-logged in users to see login page 
		 	.antMatchers("/login/").permitAll()
		 		.and()
		 		.httpBasic()
		 		.and()
		 	.formLogin()	
		 	//use the url that is served by the loginController
		 	.loginPage("/login/")
		 	
		 	//match the text input fields on the login form
		 	.usernameParameter("username")
		 	.passwordParameter("password")
		 	.permitAll()
		 	
		 	//Upon successful authentication, the user will be redirected to the /orders/all URL 
		 	//display all orders after login
		 		.defaultSuccessUrl("/orders/")
		 		.and()
		 	.logout()	
		 			.logoutUrl("/logout")
		 			.invalidateHttpSession(true)
		 			.clearAuthentication(true)
		 			.permitAll()
		 			.logoutSuccessUrl("/login/")
		 	
		 
		 // don't use CSRF in a REST api since it is used to secure <form> items, not JSON data.
		 		.and()
		 		.csrf().ignoringAntMatchers("/api/**");
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
	

