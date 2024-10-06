package com.csumb.WishlistBackendDB.services;

import com.csumb.WishlistBackendDB.models.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item);
    public List<Item> getAllItems();
    public void deleteItem(int itemID);
    public Item getItem(int itemID);
}