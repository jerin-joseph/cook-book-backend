package com.rsoclabs.cookbook;

import com.rsoclabs.cookbook.entity.User;
import com.rsoclabs.cookbook.repository.UserRepository;
import com.rsoclabs.cookbook.service.UserService;
import com.rsoclabs.cookbook.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SignupTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User u1 = new User(null,"Jerin","Joseph","jerin@rsoclabs.com","password");
        User savedUser = userService.saveUser(u1);
        assertTrue(savedUser.getId()>0);

    }
}
