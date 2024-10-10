package com.csumb.WishlistBackendDB.controllers;


import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController
{
    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public String add(@RequestBody Item item){
        itemService.addItem(item);
        return "Item added successfully";
    }

    @GetMapping("/all")
    public List<Item> getAll(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/delete/{itemID}")
    public String delete(@PathVariable("itemID") int itemID){
        itemService.deleteItem(itemID);
        return "Item deleted successfully";
    }

    @GetMapping("info/{itemID}")
    public Item getItem(@PathVariable("itemID") int itemID) {
        return itemService.getItem(itemID);
    }

}