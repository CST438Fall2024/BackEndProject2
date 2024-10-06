package com.csumb.WishlistBackendDB.controllers;


import com.csumb.WishlistBackendDB.models.Wishlist;
import com.csumb.WishlistBackendDB.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public String add(@RequestBody Wishlist wishlist){
        wishlistService.addWishlist(wishlist);
        return "Wishlist added successfully";
    }

    @GetMapping("/all")
    public List<Wishlist> getAll(){
        return wishlistService.getAllWishlists();
    }

    @DeleteMapping("/delete/{wishlistID}")
    public String delete(@PathVariable("wishlistID") int wishlistID){
        wishlistService.deleteWishlist(wishlistID);
        return "Wishlist deleted successfully";
    }

    @GetMapping("/info/{wishlistID}")
    public Wishlist getWishlist(@PathVariable("wishlistID") int wishlistID) {
        return wishlistService.getWishlist(wishlistID);
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody Wishlist wishlist) {
        int updateRes = wishlistService.editWishlist(wishlist);

        if(updateRes > 0) {
            return "Wishlist updated";
        }

        return "Can't update wishlist!";

    }

}
