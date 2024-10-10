package com.csumb.WishlistBackendDB.models;


import jakarta.persistence.*;

@Entity
@Table(name="wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wishlistID")
    private int wishlistID;

    @Column(name = "wishlistName")
    private String wishlistName;

    @Column(name = "description")
    private String description;

    @Column(name = "userID")
    private int userID = 0;


    public Wishlist(){

    }

    public int getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(int wishlistID) {
        this.wishlistID = wishlistID;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
