package com.java_security.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.java_security.models.User;
import com.java_security.repository.UserRepository;
@Component
public class StartApp implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("master123");
            user.getRoles().add("MANAGER");
            userRepository.save(user);
        }
        user = userRepository.findByUsername("user");
        if(user ==null){
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("user123");
            user.getRoles().add("USER");
            userRepository.save(user);
        }     
        User jonas = new User();
        jonas.setName("JONAS DA SILVA");
        jonas.setPassword("JONAS123");
        jonas.getRoles().add("MANAGER");
        jonas.setUsername("jon112");  
        userRepository.save(jonas);

    }

}
