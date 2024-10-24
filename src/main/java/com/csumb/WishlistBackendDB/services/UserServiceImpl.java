package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user); //.save is a JPA repository function that lets us easily add an object to our database
    }

    public List<User> getAllUsers() {
        return userRepo.findAll(); //JPA repository function to get all Users in the db
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }

    public boolean loginUser(User user){
        User foundUser =  userRepo.findUserByUsername(user.getUsername());

        System.out.println("found user is: " + foundUser);

        if(foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())){
            return true;
        }else {
            return false;
        }
    }

    public User getUserInfo(int id){
        return userRepo.findById(id);
    }

    public int editUser(User user){

        return userRepo.update(user.getUsername(), user.getPassword(), user.getUserID());

    }
}
