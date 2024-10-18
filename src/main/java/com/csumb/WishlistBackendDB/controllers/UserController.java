package com.csumb.WishlistBackendDB.controllers;

import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.services.UserService;
import jakarta.servlet.http.HttpSession;
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

    //DELETE method to delete a user
    @DeleteMapping("/delete")
    public String deleteUser(@RequestBody User user){
        int userID = user.getUserID();
        userService.deleteUser(user);
        return "User with ID " + userID + " deleted successfully";
    }

    //POST method to check login credentials
    @PostMapping("/login")
    public String loginUser(@RequestBody User user, HttpSession session) {

        boolean userExists = userService.loginUser(user);


        System.out.println("user name passed in = " + user.getUsername());
        System.out.println("user name passed in = " + user.getPassword());


        if (userExists){
            session.setAttribute("username", user.getUsername()); // store username
            return "Logging in user";
        }else{
            return "Can't find user with username: " + user.getUsername() + " password: " + user.getPassword();
        }
    }

    @GetMapping("/info/{id}")
    public User userInfo(@PathVariable("id") int id) {
        return userService.getUserInfo(id);
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody User user) {
        if(userService.editUser(user) > 0) {
            return "User edited successfully";
        }
        return "Can't find user with username: " + user.getUsername() + " password: " + user.getPassword();
    }

}
