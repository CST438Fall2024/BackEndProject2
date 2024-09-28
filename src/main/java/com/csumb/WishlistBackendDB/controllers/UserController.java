package com.csumb.WishlistBackendDB.controllers;

import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
