package com.csumb.WishlistBackendDB.repositories;

import com.csumb.WishlistBackendDB.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is used in the UserServiceImpl because it gives
 * us access to our db to post/get/put data in and out of it.
 * It also extends the JpaRepository which gives us access to common predefined CRUD operations.
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
