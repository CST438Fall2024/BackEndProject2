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
    public boolean addItem(Item item) {
        try {
            itemRepo.save(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public int deleteItem(int itemID) {
        return itemRepo.deleteByItemID(itemID);
    }

    @Override
    public Item getItem(int itemID) {
        return itemRepo.findByItemID(itemID);
    }

    @Override
    public int editItem(Item item) {
        return itemRepo.update(item.getItemName(), item.getItemLink(), item.getItemQuantity(), item.getItemID());
    }
}