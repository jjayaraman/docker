package com.jai.simple;

import com.jai.simple.entity.User;
import com.jai.simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class SimpleApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        User user = new User();
        user.setName("jay");
        user.setEmail("jj@email.com");
        userRepository.save(user);
        System.out.println("User saved : " + user);

        List<User> users = userRepository.findAll();
        System.out.println("Users ::" + users);
    }

}
