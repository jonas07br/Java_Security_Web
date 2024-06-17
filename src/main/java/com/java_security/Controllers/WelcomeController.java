package com.java_security.Controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Seja Bem Vindo!";
    }

    @GetMapping("/user")
    public String users(){
        return "Area user/manager";
    }

    @GetMapping("/manager")
    public String managers(){
        return "Area exclusiva manager";
    }

}
