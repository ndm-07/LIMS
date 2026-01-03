package com.example.claim.dao;

import com.example.claim.bean.Claim;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer> {
    // Find all claims for a specific policy
    List<Claim> findByPolicyId(int policyId);
}