package com.rsoclabs.cookbook.service;

import com.rsoclabs.cookbook.entity.User;
import com.rsoclabs.cookbook.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        log.info("to save"+user);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        User foundUser = userRepository.findByEmail(email);
        log.info("Retrieved "+foundUser);
        return Optional.ofNullable(foundUser);
    }
}
