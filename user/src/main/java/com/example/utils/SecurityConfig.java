package com.example.utils;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired 
	DataSource dataSource;
	
		
	@Override
	public void configure (HttpSecurity http) throws Exception{
		http.csrf().disable();
		//http.authorizeRequests().antMatchers("/saveUserData").permitAll().anyRequest();
		http.httpBasic().and().authorizeRequests().antMatchers("/saveUserData").permitAll();
		http.httpBasic().and().authorizeRequests().antMatchers("/getUserData").hasAuthority("ROLE_ADMIN");
		http.httpBasic().and().authorizeRequests().antMatchers("/loginUser").permitAll();
	}
	
	/*For storing authentication credentials in In-memory-storage*/
	/*@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		 auth
         .inMemoryAuthentication()
          .withUser("admin").password("{noop}admin@password").authorities(new SimpleGrantedAuthority("WRITE")).roles("ADMIN");
		
	}*/
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(16);
	}
	
	/*For storing authentication credentials in the external DB*/
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		 auth
         .jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
         .usersByUsernameQuery("SELECT username, pass_word as PASSWORD, enabled FROM user_data where username =?")
         .authoritiesByUsernameQuery("select USERNAME, rolename from user_data where USERNAME=?");
	}
	
	/*@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception{
		 auth
         .jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).usersByUsernameQuery("SELECT username, pass_word as PASSWORD, enabled FROM user_data where username =?")
         .authoritiesByUsernameQuery("SELECT rolename from rolevalues");
	}*/
    }
	

