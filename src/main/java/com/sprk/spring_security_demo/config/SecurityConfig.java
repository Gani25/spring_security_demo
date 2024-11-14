package com.sprk.spring_security_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails rajeev = User
                .withUsername("rajeev")
                .password("{noop}123")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("parth")
                .password("{noop}admin123")
                .roles("ADMIN","USER")
                .build();

        UserDetails manager = User
                .withUsername("Rohan")
                .password("{noop}man123")
                .roles("ADMIN","USER","MANAGER")
                .build();



        return new InMemoryUserDetailsManager(rajeev,admin, manager);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request)-> request
                .requestMatchers("/","/home").permitAll()
                .anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
