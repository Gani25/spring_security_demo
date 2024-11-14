package com.sprk.spring_security_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/welcome")
    public String showWelcome(){
        return "Welcome to Spring Security Demo";
    }

    @GetMapping({"/home","/"})
    public String showHome(){
        return "Home Page of Spring Security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String showAdmin(){
        return "Admin Page of Spring Security";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String showUser(){
        return "User Page of Spring Security";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    public String showManager(){
        return "Manager Page of Spring Security";
    }
}
