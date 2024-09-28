package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public List<User> getAllUsers();

}
