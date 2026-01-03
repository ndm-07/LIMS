package com.example.auth.dao;

import com.example.auth.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterDao extends CrudRepository<User, Integer> {

    // Custom method to check if a user exists
    boolean existsByUsername(String username);

    // Custom method to find a user if needed
    Optional<User> findByUsername(String username);
}