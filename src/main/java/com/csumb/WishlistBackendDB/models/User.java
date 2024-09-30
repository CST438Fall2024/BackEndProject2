package com.csumb.WishlistBackendDB.models;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Entity class for User objects which are used to create
 * User objects that will be used to store in the database.
 * When creating a new User json object using the API, only pass in the username and password
 * all other fields will have a default
 */

@Entity
@Table(name = "users") //make sure it follows the rules of our 'users' table in our db
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userID; //userID is the primary key and auto incremented
    @Column(name = "username")
    private String username; //username has to be passed in the json object, it has no default value
    @Column(name = "password")
    private String password; //password has to be passed in the json object, it has no default value
    @Column(name = "email")
    private String email = null; //email defaults to null, don't know if we'll use it
    @Column(name = "isAdmin")
    private Boolean isAdmin = false; //admin defaults to false, change the users that are admin within the db itself

    public User() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
