package com.rsoclabs.cookbook.service;

import com.rsoclabs.cookbook.entity.User;

import java.util.Optional;

public interface UserService {
        User  saveUser(User user);

        Optional<User> findUserByEmail(String email);

}

