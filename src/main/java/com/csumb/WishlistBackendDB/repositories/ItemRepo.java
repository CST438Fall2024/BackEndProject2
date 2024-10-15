package com.csumb.WishlistBackendDB.repositories;

import com.csumb.WishlistBackendDB.models.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Item i WHERE i.itemID = :itemID")
    int deleteByItemID(@Param("itemID") int itemID);

    @Query("SELECT i FROM Item i WHERE i.itemID = :itemID")
    Item findByItemID(@Param("itemID") int itemID);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.itemName = :itemName, i.itemLink = :itemLink, i.itemQuantity = :itemQuantity WHERE i.itemID = :itemID")
    int update(@Param("itemName") String itemName, @Param("itemLink") String itemLink, @Param("itemQuantity") int itemQuantity, @Param("itemID") int itemID);
}