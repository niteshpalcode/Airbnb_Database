package com.airbnb.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.airbnb.Security.CustomeUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomeUserDetailService customeUserDetailService;
	
	
	public static final String[] PUBLIC_URL= {"/auth/**",
			"/v3/api-docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		super.configure();
//		disable first
		
		
		http
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers(PUBLIC_URL)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customeUserDetailService).passwordEncoder(passwordEncoder());

	}
	
	

}
