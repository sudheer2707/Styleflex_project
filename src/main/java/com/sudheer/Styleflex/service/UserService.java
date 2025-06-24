package com.sudheer.Styleflex.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sudheer.Styleflex.Model.User;
import com.sudheer.Styleflex.ProductRepo.UserRepository;

@Service
public class UserService implements ServiceInterface{

    @Autowired
    private UserRepository userRepository;

@Autowired
 private BCryptPasswordEncoder passwordEncoder;

@Override
 public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
     @Override
    public User loginUser(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
     public static String loginUser(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'loginUser'");
     }
}

