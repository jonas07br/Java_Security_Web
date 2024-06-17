package com.java_security.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_security.models.User;
import com.java_security.repository.UserRepository;

@RestController
public class WelcomeController {
    @Autowired
    UserRepository userRepository;
    @GetMapping
    public String welcome(){
        return "Seja Bem Vindo!";
    }

    @GetMapping("/logado")
    public String loginArea(){
        
        return "Logado com:"+SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/user")
    public String users(){
        return "Area user/manager";
    }

    @GetMapping("/manager/showusers")
    public List<User> showUsers(){
        List<User> lista = userRepository.findAll();
        return lista;
    }

    @GetMapping("/manager")
    public String managers(){
        return "Area exclusiva manager";
    }

    
}
