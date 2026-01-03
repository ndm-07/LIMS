package com.example.auth.dao;

import com.example.auth.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthDao extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}