package com.rsoclabs.cookbook.controller;

import com.rsoclabs.cookbook.entity.User;
import com.rsoclabs.cookbook.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String CookBook(){
        return "Welcome to CookBook Backend!";
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<Object> signup(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(errors.getFieldError(),HttpStatus.BAD_REQUEST);
        }
        User savedUser = userService.saveUser(user);
        log.info("Created "+savedUser.toString());
        return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestParam String username,@RequestParam String password){

        log.info(username+password);
        Optional<User> foundUser = userService.findUserByEmail(username);
        if(foundUser.isPresent()){
            User user = foundUser.get();
            Boolean result = user.getPassword().equals(password);
            if(result.equals(true)){
                return new ResponseEntity<>(user,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Authentication Failed",HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>("Authentication failed",HttpStatus.OK);
        }
    }

}
