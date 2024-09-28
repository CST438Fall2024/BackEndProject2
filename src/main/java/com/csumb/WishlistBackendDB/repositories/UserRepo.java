package com.csumb.WishlistBackendDB.repositories;

import com.csumb.WishlistBackendDB.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
