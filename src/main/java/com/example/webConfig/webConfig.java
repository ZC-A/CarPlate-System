package com.example.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.net.Authenticator;

@Configuration
@EnableWebSecurity
public class webConfig extends WebSecurityConfigurerAdapter {

        @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {

               auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("operator").password("xidiancar").roles("ADMIN"); }



               @Override protected void configure(HttpSecurity http) throws Exception {
               http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/");

               http.csrf().disable();

              }

}


