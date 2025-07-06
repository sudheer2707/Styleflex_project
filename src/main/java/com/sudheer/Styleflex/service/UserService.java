package com.sudheer.Styleflex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sudheer.Styleflex.Model.User;
import com.sudheer.Styleflex.ProductRepo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register new user
    public User registerUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Login user
    public String loginUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password!";
            }
        } else {
            return "User not found!";
        }
    }
}
