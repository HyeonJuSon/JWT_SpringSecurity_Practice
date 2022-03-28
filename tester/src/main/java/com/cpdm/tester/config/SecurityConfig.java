package com.cpdm.tester.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // use basic web security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http    // HttpServletRequest authorize setting
                .authorizeRequests()
                // allow request
                .antMatchers("/api/cpdm").permitAll()
                // have to authenticate
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                //h2-console 하위 모든 요청, favicon관련 요청은 Spring Security 로직을 수행하지 않도록 한다.
                .antMatchers(
                        "/h2-console/**"
                        , "/favicon.ico"
                );
    }
}
