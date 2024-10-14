package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.Item;

import java.util.List;

public interface ItemService {
    public boolean addItem(Item item);
    public List<Item> getAllItems();
    public int deleteItem(int itemID);
    public Item getItem(int itemID);
    public int editItem(Item item);
}