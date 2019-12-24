package com.morteza.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //solution 1 for spring 5 password exception = {noop}
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("{noop}123456").roles("DBA");
//
//    }

    //solution 2 for spring 5 password exception = this method
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("mkyong").password(passwordEncoder().encode("123456")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password(passwordEncoder().encode("123456")).roles("DBA");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests().anyRequest().authenticated().and().formLogin();
        http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/dba").access("hasRole('DBA')")
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
