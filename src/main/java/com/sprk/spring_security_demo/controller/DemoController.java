package com.sprk.spring_security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/welcome")
    public String showWelcome(){
        return "Welcome to Spring Security Demo";
    }

    @GetMapping("/home")
    public String showHome(){
        return "Home Page of Spring Security";
    }
}
