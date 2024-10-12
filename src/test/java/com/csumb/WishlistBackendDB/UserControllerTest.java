package com.csumb.WishlistBackendDB;

import com.csumb.WishlistBackendDB.controllers.UserController;
import com.csumb.WishlistBackendDB.models.User;
import com.csumb.WishlistBackendDB.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void addUserTest() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        mockMvc.perform(post("/users/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\", \"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User added successfully"));

        verify(userService, times(1)).addUser(any(User.class));
    }

    @Test
    void getAllUsersTest() throws Exception {
        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void deleteUserTest() throws Exception {
        User user = new User();
        user.setUserID(1);

        mockMvc.perform(delete("/users/delete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userID\":1, \"username\":\"testUser\", \"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("User with ID 1 deleted successfully"));

        verify(userService, times(1)).deleteUser(any(User.class));
    }

    @Test
    void loginUserTest() throws Exception {
        when(userService.loginUser(any(User.class))).thenReturn(true);

        mockMvc.perform(post("/users/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testUser\", \"password\":\"password\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Logging in user"));

        verify(userService, times(1)).loginUser(any(User.class));
    }

    @Test
    void getUserInfoTest() throws Exception {
        User user = new User();
        user.setUserID(1);

        when(userService.getUserInfo(1)).thenReturn(user);

        mockMvc.perform(get("/users/info/1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getUserInfo(1);
    }
}
