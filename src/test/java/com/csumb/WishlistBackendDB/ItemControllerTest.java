package com.csumb.WishlistBackendDB;

import com.csumb.WishlistBackendDB.controllers.ItemController;
import com.csumb.WishlistBackendDB.models.Item;
import com.csumb.WishlistBackendDB.services.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ItemControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    void addItemTest() throws Exception {
        Item item = new Item();
        item.setItemName("Test Item");

        mockMvc.perform(post("/items/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"itemName\":\"Test Item\", \"itemLink\":\"http://example.com\", \"itemQuantity\":1, \"wishlistID\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Item added successfully"));

        verify(itemService, times(1)).addItem(any(Item.class));
    }

    @Test
    void getAllItemsTest() throws Exception {
        List<Item> items = new ArrayList<>();
        when(itemService.getAllItems()).thenReturn(items);

        mockMvc.perform(get("/items/all"))
                .andExpect(status().isOk());

        verify(itemService, times(1)).getAllItems();
    }

    @Test
    void deleteItemTest() throws Exception {
        int itemID = 1;

        mockMvc.perform(delete("/items/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Item deleted successfully"));

        verify(itemService, times(1)).deleteItem(itemID);
    }

    @Test
    void getItemTest() throws Exception {
        Item item = new Item();
        item.setItemID(1);
        when(itemService.getItem(1)).thenReturn(item);

        mockMvc.perform(get("/items/info/1"))
                .andExpect(status().isOk());

        verify(itemService, times(1)).getItem(1);
    }
}
