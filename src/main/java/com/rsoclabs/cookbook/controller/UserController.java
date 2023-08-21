package com.rsoclabs.cookbook.controller;

import com.rsoclabs.cookbook.entity.User;
import com.rsoclabs.cookbook.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }

}
