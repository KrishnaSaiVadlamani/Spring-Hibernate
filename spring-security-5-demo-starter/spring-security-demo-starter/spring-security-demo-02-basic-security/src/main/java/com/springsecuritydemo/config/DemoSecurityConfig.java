package com.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends
        WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // add our uses for in memory authentication

        User.UserBuilder users=User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("Krishna").password("krishna123").roles("Employee"))
        .withUser(users.username("Sahithi").password("sahithi123").roles("Admin"))
        .withUser(users.username("Rakesh").password("rakesh123").roles("Manager"));
    }
}
