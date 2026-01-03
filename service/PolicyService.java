package com.example.policy.service;

import com.example.policy.bean.Policy;
import com.example.policy.dao.PolicyHomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyHomeDao policyHomeDao;

    public void savePolicy(Policy policy) {
        policyHomeDao.save(policy);
    }

    public List<Policy> getAllPolicies() {
        return (List<Policy>) policyHomeDao.findAll();
    }

    public Optional<Policy> getPolicyByNumber(String policyNumber) {
        return policyHomeDao.findByPolicyNumber(policyNumber);
    }

    public void deletePolicy(Integer id) {
        policyHomeDao.deleteById(id);
    }

    public Optional<Policy> getPolicyById(Integer id) {
        return policyHomeDao.findById(id);
    }

    public boolean deleteByPolicyNumber(String policyNumber) {
        Optional<Policy> policyOpt = policyHomeDao.findByPolicyNumber(policyNumber);
        if (policyOpt.isPresent()) {
            policyHomeDao.delete(policyOpt.get());
            return true;
        }
        return false;
    }
}