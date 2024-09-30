package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The controller API endpoints connect to this class where the logic is defined.
 * This class uses an instance of UserRepo to gain access to JPA repository functions
 * and get a connection to our database
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo; //An instance of UserRepo lets us get an instance of our database
                               // and access to predefined JPA repository functions since userRepo extends it

    @Override
    public User addUser(User user) {
        return userRepo.save(user); //.save is a JPA repository function that lets us easily add an object to our database
    }

    public List<User> getAllUsers() {
        return userRepo.findAll(); //JPA repository function to get all Users in the db
    }
}
