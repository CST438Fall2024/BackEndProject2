package com.csumb.WishlistBackendDB.repositories;


import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.models.Wishlist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer> {

    @Query("SELECT w FROM Wishlist w WHERE w.wishlistID = :wishlistID")
    Wishlist findByWishlistID(@Param("wishlistID") int wishlistID);


    @Modifying
    @Transactional
    @Query("UPDATE Wishlist w SET w.wishlistName = :wishlistName, w.description = :description WHERE w.wishlistID = :wishlistID")
    int update(@Param("wishlistName") String wishlistName, @Param("description") String description, @Param("wishlistID") int wishlistID);

    @Query
    ("SELECT w FROM Wishlist w WHERE w.userID = :userID")
    List<Wishlist> findWishlistsByUser(@Param("userID") int userID);

    @Query("SELECT i FROM Item i WHERE i.wishlistID = :wishlistID")
    List<Item> findItemsByWishlistID(@Param("wishlistID") int wishlistID);

}
