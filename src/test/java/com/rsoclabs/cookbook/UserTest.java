package com.rsoclabs.cookbook;

import com.rsoclabs.cookbook.entity.User;
import com.rsoclabs.cookbook.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User u1 = new User(null,"Jerin","Joseph","jerin@rsoclabs.com","password");
        User savedUser = userService.saveUser(u1);
        assertTrue(savedUser.getId()>0);

    }

    @Test
    public void findUserByEmail(){
        String email="jerin@rsoclabs.com";
        String password="password";
        Optional<User> foundUser = userService.findUserByEmail(email);
        assertNotNull(foundUser.get());
        assertEquals(foundUser.get().getPassword(),password);
    }
}
