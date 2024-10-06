package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.Wishlist;
import com.csumb.WishlistBackendDB.repositories.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService{

    @Autowired
    private WishlistRepo wishlistRepo;

    @Override
    public Wishlist addWishlist(Wishlist wishlist) {
        return wishlistRepo.save(wishlist);
    }

    @Override
    public List<Wishlist> getAllWishlists() {
        return wishlistRepo.findAll();
    }

    @Override
    public void deleteWishlist(int wishlistID) {

        wishlistRepo.deleteById(wishlistID);
    }

    @Override
    public Wishlist getWishlist(int wishlistID) {
        return wishlistRepo.findByWishlistID(wishlistID);
    }

    @Override
    public int editWishlist(Wishlist wishlist) {
        return wishlistRepo.update(wishlist.getWishlistName(), wishlist.getDescription(), wishlist.getWishlistID());
    }


}
