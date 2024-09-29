package com.csumb.WishlistBackendDB.controllers;

import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is used to define the API endpoints and their names
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; //getting an instance of UserService which houses the function logic

    //POST method to add a user
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        //when sending a User json object in the API, only the username and password have to be provided
        //all other fields will have a default value

        userService.addUser(user); //uses an instance of UserService class to use the logic to add there
        return "User added successfully";
    }

    //GET method to get all users
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
