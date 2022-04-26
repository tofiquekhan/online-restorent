package com.webkorps.onlinerestorent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.webkorps.onlinerestorent.service.impl.RestroUserDetailService;

@Configuration
@EnableWebSecurity
public class RestroSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private RestroUserDetailService restroUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http
	.csrf().disable()
	.authorizeRequests()
	.antMatchers("/user/**").permitAll()
	.anyRequest()
	.authenticated()
	.and()
	.formLogin()
	.loginPage("/user/signin")
	.loginProcessingUrl("/doLogin")
	.defaultSuccessUrl("/client/restro/")
	;
	
	
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(restroUserDetailService).passwordEncoder(passwordEncoder());
	
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	
	
}
