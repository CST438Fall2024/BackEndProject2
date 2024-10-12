package com.csumb.WishlistBackendDB;

import com.csumb.WishlistBackendDB.controllers.WishlistController;
import com.csumb.WishlistBackendDB.models.Wishlist;
import com.csumb.WishlistBackendDB.services.WishlistService;
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

class WishlistControllerTest {

    private MockMvc mockMvc;

    @Mock
    private WishlistService wishlistService;

    @InjectMocks
    private WishlistController wishlistController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(wishlistController).build();
    }

    @Test
    void addWishlistTest() throws Exception {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistName("Test Wishlist");

        mockMvc.perform(post("/wishlists/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"wishlistName\":\"Test Wishlist\", \"description\":\"Test description\", \"userID\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wishlist added successfully"));

        verify(wishlistService, times(1)).addWishlist(any(Wishlist.class));
    }

    @Test
    void getAllWishlistsTest() throws Exception {
        List<Wishlist> wishlists = new ArrayList<>();
        when(wishlistService.getAllWishlists()).thenReturn(wishlists);

        mockMvc.perform(get("/wishlists/all"))
                .andExpect(status().isOk());

        verify(wishlistService, times(1)).getAllWishlists();
    }

    @Test
    void deleteWishlistTest() throws Exception {
        int wishlistID = 1;

        mockMvc.perform(delete("/wishlists/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wishlist deleted successfully"));

        verify(wishlistService, times(1)).deleteWishlist(wishlistID);
    }

    @Test
    void getWishlistTest() throws Exception {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistID(1);
        when(wishlistService.getWishlist(1)).thenReturn(wishlist);

        mockMvc.perform(get("/wishlists/info/1"))
                .andExpect(status().isOk());

        verify(wishlistService, times(1)).getWishlist(1);
    }

    @Test
    void editWishlistTest() throws Exception {
        Wishlist wishlist = new Wishlist();
        wishlist.setWishlistID(1);
        wishlist.setWishlistName("Updated Wishlist");
        wishlist.setDescription("Updated description");

        when(wishlistService.editWishlist(any(Wishlist.class))).thenReturn(1);

        mockMvc.perform(put("/wishlists/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"wishlistID\":1, \"wishlistName\":\"Updated Wishlist\", \"description\":\"Updated description\", \"userID\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Wishlist updated"));

        verify(wishlistService, times(1)).editWishlist(any(Wishlist.class));
    }
}
