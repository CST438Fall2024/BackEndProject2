package com.csumb.WishlistBackendDB.services;


import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.models.Wishlist;

import java.util.List;

public interface WishlistService {

    public Wishlist addWishlist(Wishlist wishlist);
    public List<Wishlist> getAllWishlists();
    public void deleteWishlist(int wishlistID);
    public Wishlist getWishlist(int wishlistID);
    public int editWishlist(Wishlist wishlist);
    public List<Wishlist> searchWishlistByUser(int userID);
    public List<Item> getWishlistItems(int wishlistID);
}
