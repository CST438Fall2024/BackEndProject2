package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.User;

import java.util.List;

/**
 * Simple interface for UserServiceImp
 * This class is actually not that important
 */

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(User user);
    public boolean loginUser(User user);
    public  User getUserInfo(int id);
    public int editUser(User user);
}
