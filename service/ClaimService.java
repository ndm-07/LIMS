package com.example.claim.service;

import com.example.claim.bean.Claim;
import com.example.claim.dao.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository repository;

    public List<Claim> getAllClaims() {
        // Fetching all records from the 'claim' table
        return (List<Claim>) repository.findAll();
    }

    public void submitClaim(Claim claim) {
        if (claim.getClaimStatus() == null) {
            claim.setClaimStatus(Claim.ClaimStatus.OPEN);
        }
        repository.save(claim);
    }

    public Claim getClaimDetails(int id) {
        Optional<Claim> claim = repository.findById(id);
        return claim.orElse(null);
    }
}