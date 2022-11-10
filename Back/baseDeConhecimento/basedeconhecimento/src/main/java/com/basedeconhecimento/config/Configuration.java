package com.basedeconhecimento.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;



@org.springframework.context.annotation.Configuration
public class Configuration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .antMatchers("/**").permitAll()
                .antMatchers(HttpMethod.GET, "/topico/**").permitAll()
                .antMatchers(HttpMethod.GET, "/categoria/**").permitAll()
                .antMatchers(HttpMethod.POST, "/topico/**").permitAll()
                .antMatchers(HttpMethod.POST, "/categoria/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/topico/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/categoria/**").permitAll()
                .anyRequest().authenticated()
                .and().cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }


}

