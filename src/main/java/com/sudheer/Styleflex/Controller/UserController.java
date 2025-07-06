package com.sudheer.Styleflex.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.sudheer.Styleflex.Model.User;
import com.sudheer.Styleflex.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
public class UserController {

    @Autowired
    private UserService userService;

    // Register
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return "User registered successfully!";
        } catch (RuntimeException ex) {
            return ex.getMessage(); // Email already registered
        }
    }

    // Login
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }
}
