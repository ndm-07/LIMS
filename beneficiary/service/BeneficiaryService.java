package com.example.beneficiary.service;

import com.example.beneficiary.bean.Beneficiary;
import com.example.beneficiary.dao.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    public List<Beneficiary> listAll() {
        // CrudRepository returns Iterable, so we cast to List
        return (List<Beneficiary>) repository.findAll();
    }

    public void save(Beneficiary beneficiary) {
        repository.save(beneficiary);
    }

    public void remove(int id) {
        repository.deleteById(id);
    }
}