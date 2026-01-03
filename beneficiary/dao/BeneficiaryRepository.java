package com.example.beneficiary.dao;

import com.example.beneficiary.bean.Beneficiary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer> {
    // Basic CRUD methods like save(), findAll(), and deleteById() are automatically provided.
}