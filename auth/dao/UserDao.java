package com.example.auth.dao;

import com.example.auth.bean.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}