package com.csumb.WishlistBackendDB.repositories;

import com.csumb.WishlistBackendDB.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * This interface is used in the UserServiceImpl because it gives
 * us access to our db to post/get/put data in and out of it.
 * It also extends the JpaRepository which gives us access to common predefined CRUD operations.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    //creates a manual SQL query to check username and password
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User login(@Param("username") String username, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.userID = :id")
    User findById(@Param("id") int id);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.username = :username, u.password = :password WHERE u.userID = :id")
    int update(@Param("username") String username, @Param("password") String password, @Param("id") int id);
}
