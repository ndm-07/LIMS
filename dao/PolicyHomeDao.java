package com.example.policy.dao;

import com.example.policy.bean.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyHomeDao extends CrudRepository<Policy, Integer> {

    // Derived Query: find + By + PropertyName
    Optional<Policy> findByPolicyNumber(String policyNumber);
}