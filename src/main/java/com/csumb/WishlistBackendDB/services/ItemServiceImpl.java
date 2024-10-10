package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.repositories.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public Item addItem(Item item) {
        return itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public void deleteItem(int itemID) {
        itemRepo.deleteByItemID(itemID);
    }

    @Override
    public Item getItem(int itemID) {
        return itemRepo.findByItemID(itemID);
    }
}