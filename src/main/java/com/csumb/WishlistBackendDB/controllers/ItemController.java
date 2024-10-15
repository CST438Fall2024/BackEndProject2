package com.csumb.WishlistBackendDB.controllers;


import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.models.Wishlist;
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
        if(itemService.addItem(item)){
            return "Item added successfully";
        } else {
            return "Item cannot be added";
        }
    }

    @GetMapping("/all")
    public List<Item> getAll(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/delete/{itemID}")
    public String delete(@PathVariable("itemID") int itemID){
        int deleteRes = itemService.deleteItem(itemID);

        if(deleteRes > 0) {
            return "Item deleted successfully";
        } else {
            return "Item not deleted";
        }
    }

    @GetMapping("/info/{itemID}")
    public Item getItem(@PathVariable("itemID") int itemID) {
        return itemService.getItem(itemID);
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody Item item) {
        int updateRes = itemService.editItem(item);

        if(updateRes > 0) {
            return "Item updated";
        }

        return "Can't update item!";

    }



}